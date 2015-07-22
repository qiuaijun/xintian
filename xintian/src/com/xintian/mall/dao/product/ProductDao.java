package com.xintian.mall.dao.product;

import com.xintian.mall.dao.BaseDao;
import com.xintian.mall.model.product.ProductInfo;

import java.util.List;


public interface ProductDao extends BaseDao<ProductInfo> {
	public List<ProductInfo> findCommend();
}
