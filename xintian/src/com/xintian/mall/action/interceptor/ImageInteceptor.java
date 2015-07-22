package com.xintian.mall.action.interceptor;

import com.aliyun.oss.OSSClient;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xintian.mall.action.product.ProductAction;
import com.xintian.mall.model.PageModel;
import com.xintian.mall.model.product.ProductInfo;
import com.xintian.mall.promotion.model.PromotionInfo;

import java.net.URL;
import java.util.Date;

/**
 * Created by aijun on 15/7/22.
 */
public class ImageInteceptor extends AbstractInterceptor {
    public static String ACCESS_ID = "phbkJFIMechVNC6b";
    public static String ACCESS_KEY = "2cJxWAfsj8WMl3UbhURDGNNJE4okcj";
    public static String endPoint = "http://oss-cn-shenzhen.aliyuncs.com";

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String resultCode = invocation.invoke();

        ProductAction productAction = (ProductAction) invocation.getAction();
        PageModel<ProductInfo> pm = productAction.getPageModel();
        if (pm != null && pm.getList().size() > 0) {
            for (ProductInfo p : pm.getList()) {
                p.setBigImageAddress(getImageUrl(p.getBigImageAddress()));
                p.setGoodsImageAddress(getImageUrl(p.getGoodsImageAddress()));
            }
        }
        return resultCode;

    }

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
