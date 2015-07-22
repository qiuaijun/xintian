package com.xintian.mall.dao.user;


import com.xintian.mall.dao.BaseDao;
import com.xintian.mall.model.user.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	public Customer login(String username, String password);
	public boolean isUnique(String username);
}
