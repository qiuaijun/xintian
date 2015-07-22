package com.xintian.mall.model.order;

import java.io.Serializable;
/**
 * �����е���Ʒ��Ŀ
 */
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;                       // ��Ʒ��Ŀ���
	private Integer productId;                // ��Ʒid
	private String productName;               // ��Ʒ���	
	private Double productPrice;              // ��Ʒ�۸�
	private Double productPreferentialPrice;  // �Żݼ۸�
	private Integer buyNum=1;                 // ��������
	private Order order;                      // ��������
	private String imageAddress;              //ͼƬ��ַ
	private String productCode;	              // ��Ʒ���		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double price) {
		this.productPrice = price;
	}
	public Double getProductPreferentialPrice() {
		return productPreferentialPrice;
	}
	public void setProductPreferentialPrice(Double price) {
		this.productPreferentialPrice = price;
	}		
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer num) {
		this.buyNum = num;
	}	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public void setImageAddress(String image) {
		this.imageAddress = image;
	}    
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String code) {
		this.productCode = code;
	}
}
