package com.xintian.mall.model.order;

import com.xintian.mall.model.user.Customer;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * ����
 */
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	//private String orderId;// �������
	private String orderCode;// �������(�ֶ�����)	
	private String name;// �ջ�������
	private String address;// �ͻ���ַ
	private String phone;// �ջ�����ϵ�绰	
	private Double totalPrice;// �����ܽ��
	private Date createTime = new Date();// �µ�ʱ��	
	private String paymentWay;// ֧����ʽ
	private String orderState;// ����״̬
	private Customer customer;// �����ͻ�
	private Set<OrderItem> orderItems;// ������Ʒ
/*	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String id) {
		this.orderId = id;
	} */  
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String code) {
		this.orderCode = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}	
	
	public String getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}	
}
