package com.xintian.mall.action;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.xintian.mall.dao.order.OrderDao;
import com.xintian.mall.dao.product.ProductDao;
import com.xintian.mall.dao.user.CustomerDao;
import com.xintian.mall.model.order.OrderItem;
import com.xintian.mall.model.user.Customer;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;


import com.opensymphony.xwork2.ActionSupport;
/**
 * ��Action�࣬����Action�ĸ���
 */
@SuppressWarnings("unused")
public class BaseAction extends ActionSupport implements RequestAware,SessionAware, ApplicationAware {
	private static final long serialVersionUID = 1L;
	protected int pageSize = 5;
	public static final String LIST = "list";
	public static final String EDIT = "edit";
	public static final String ADD = "add";
	public static final String SELECT = "select";
	public static final String QUERY = "query";
	public static final String INDEX = "index";
	public static final String Register = "register";
	public static final String CUSTOMER_LOGIN = "customerLogin";
	public static final String LOGOUT = "logout";
	// ��ȡ��ͨ�û�����
	public Customer getLoginCustomer(){
		if(session.get("customer") != null){
			return (Customer) session.get("customer");
		}
		return null;
	}
	// ��session��ȡ�����ﳵ
	@SuppressWarnings("unchecked")
	protected Set<OrderItem> getCart(){
		Object obj = session.get("cart");
		if(obj == null){
			return new HashSet<OrderItem>();
		}else{
			return (Set<OrderItem>) obj;
		}
	}	
	// ע��Dao
	@Autowired
	protected ProductDao productDao;
	@Autowired
	protected OrderDao orderDao;
	@Autowired
	protected CustomerDao customerDao;
	// Map���͵�request
	protected Map<String, Object> request;
	// Map���͵�session
	protected Map<String, Object> session;
	// Map���͵�application
	protected Map<String, Object> application;
	
	@Override
	public void setRequest(Map<String, Object> request) {
		// ��ȡMap���͵�request��ֵ
		this.request = request;
	}
	@Override
	public void setApplication(Map<String, Object> application) {
		// ��ȡMap���͵�application��ֵ
		this.application = application;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// ��ȡMap���͵�session��ֵ
		this.session = session;
	}
	
	// ���?��
	public String execute() throws Exception {
		return SUCCESS;
	}	
	public String index() throws Exception {
		return INDEX;
	}
	public String add() throws Exception {
		return ADD;
	}
	public String select() throws Exception {
		return SELECT;
	}
	public String query() throws Exception{
		return QUERY;
	}	
	public String register() throws Exception{
		return Register;
	}
	// getter()��setter()����	
	protected int pageNo = 1;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
