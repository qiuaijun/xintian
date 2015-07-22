package com.xintian.mall.promotion.dao;

import java.util.Map;

/**
 * Created by aijun on 15/7/3.
 */
public interface Counter2AddressDao {
    public void addNum(String address);


    public Map<String, String> getAllAddressStatics();
}
