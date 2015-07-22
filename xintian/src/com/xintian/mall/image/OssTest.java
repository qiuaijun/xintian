package com.xintian.mall.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSErrorCode;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.ServiceException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;

/**
 * Created by aijun on 15/7/19.
 */
public class OssTest {


    public static String ACCESS_ID = "phbkJFIMechVNC6b";
    public static String ACCESS_KEY = "2cJxWAfsj8WMl3UbhURDGNNJE4okcj";
    public static String endPoint = "http://oss-cn-shenzhen.aliyuncs.com";

    public static void main(String[] args) throws Exception {
        String bucketName = "xin-tian";
        String key = "image/a.txt";

        // 使用默认的OSS服务器地址创建OSSClient对象。
        OSSClient client = new OSSClient(endPoint, ACCESS_ID, ACCESS_KEY);

        try {
            ensureBucket(client, bucketName);
            ObjectListing ObjectListing = client.listObjects(bucketName);
            List<OSSObjectSummary> listDeletes = ObjectListing
                    .getObjectSummaries();

            uploadFile(client, bucketName, key, "/usr/local/LICENSE.txt");


            for (int i = 0; i < listDeletes.size(); i++) {
                String objectName = listDeletes.get(i).getKey();
                System.out.println(objectName);
            }
            URL url = client.generatePresignedUrl(bucketName, key, new Date(System.currentTimeMillis() + 1000 * 60 * 60));

            System.out.println(url.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 创建Bucket.
    private static void ensureBucket(OSSClient client, String bucketName)
            throws OSSException, ClientException {

        try {
            // 创建bucket
            client.createBucket(bucketName);
        } catch (ServiceException e) {
            if (!OSSErrorCode.BUCKET_ALREADY_EXISTS.equals(e.getErrorCode())) {
                // 如果Bucket已经存在，则忽略
                throw e;
            }
        }
    }

    // 删除一个Bucket和其中的Objects
    private static void deleteBucket(OSSClient client, String bucketName)
            throws OSSException, ClientException {

        ObjectListing ObjectListing = client.listObjects(bucketName);
        List<OSSObjectSummary> listDeletes = ObjectListing
                .getObjectSummaries();
        for (int i = 0; i < listDeletes.size(); i++) {
            String objectName = listDeletes.get(i).getKey();
            // 如果不为空，先删除bucket下的文件
            client.deleteObject(bucketName, objectName);
        }
        client.deleteBucket(bucketName);
    }

    // 把Bucket设置为所有人可读
    private static void setBucketPublicReadable(OSSClient client, String bucketName)
            throws OSSException, ClientException {
        //创建bucket
        client.createBucket(bucketName);

        //设置bucket的访问权限，public-read-write权限
        client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
    }

    // 上传文件
    private static void uploadFile(OSSClient client, String bucketName, String key, String filename)
            throws OSSException, ClientException, FileNotFoundException {
        File file = new File(filename);

        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentLength(file.length());

        // 可以在metadata中标记文件类型
        //objectMeta.setContentType("image/jpeg");

        InputStream input = new FileInputStream(file);
        client.putObject(bucketName, key, input, objectMeta);
    }

    // 下载文件
    private static void downloadFile(OSSClient client, String bucketName, String key, String filename)
            throws OSSException, ClientException {
        client.getObject(new GetObjectRequest(bucketName, key),
                new File(filename));
    }
}
