package com.xintian.mall.dao.order;

import com.xintian.mall.dao.BaseDao;
import com.xintian.mall.model.order.Order;

public interface OrderDao extends BaseDao<Order> {
	public Order findByCustomer(int customerId);
}
