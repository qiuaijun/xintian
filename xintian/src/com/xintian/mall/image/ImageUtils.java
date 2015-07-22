package com.xintian.mall.image;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by aijun on 15/7/19.
 */
public class ImageUtils {
    public static String ACCESS_ID = "phbkJFIMechVNC6b";
    public static String ACCESS_KEY = "2cJxWAfsj8WMl3UbhURDGNNJE4okcj";
    public static String endPoint = "http://oss-cn-shenzhen.aliyuncs.com";

    public static String getImageUrl(String key) {
        String bucketName = "xin-tian";
        URL url = null;
        // 使用默认的OSS服务器地址创建OSSClient对象。
        OSSClient client = new OSSClient(endPoint, ACCESS_ID, ACCESS_KEY);

        try {
            url = client.generatePresignedUrl(bucketName, key, new Date(System.currentTimeMillis() + 1000 * 60 * 60));
            System.out.println(url.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (url == null) {
            return null;
        }
        return url.toString();
    }
}
