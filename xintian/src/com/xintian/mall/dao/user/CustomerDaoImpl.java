package com.xintian.mall.dao.user;

import java.util.List;

import com.xintian.mall.dao.DaoSupport;
import com.xintian.mall.model.user.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends DaoSupport<Customer> implements CustomerDao {
  @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
  public Customer login(String username, String password) {
	  if(username != null && password != null){
		  String where = "where username=? and password=?";
		  Object[] queryParams = {username,password};
		  List<Customer> list = find(-1, -1, where, queryParams).getList();
		  if(list != null && list.size() > 0){
			  return list.get(0);
		  }
	  }
	  return null;
  }

  @SuppressWarnings("rawtypes")
  @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
  public boolean isUnique(String username) {
	  Object[] queryParams = {username};//���ò����������
	  List list = (List)super.uniqueResult("from Customer where username = ?", queryParams);
//		List list = super.getSession().find("from Customer where username = ?", username);
	  if(list != null && list.size() > 0){
		  return false;
	  }
	  return true;
  }
}
