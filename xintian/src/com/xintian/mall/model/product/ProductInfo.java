package com.xintian.mall.model.product;

import java.io.Serializable;
import java.util.Date;
/**
 * ��Ʒ��Ϣ
 */
public class ProductInfo implements Serializable {
	private static final long serialVersionUID = 1L;
/*	public ProductInfo() {
	}

	*//** full constructor *//*
	public ProductInfo(String code, String name, Double price, Double newprice,Integer num) {
		this.goodsCode = code;
		this.goodsName = name;
		this.goodsPrice = price;
		this.goodsPreferentialPrice = newprice;
		this.goodsStockNumber = num;
	}*/
	
	// ��ƷID
    private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	// ��Ʒ���
    private String goodsCode;
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String code) {
		this.goodsCode = code;
	}
	
    // ��Ʒ���
    private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    // �ͺŲ���
    private String model;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	// �۸�
    private Double goodsPrice;
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double price) {
		this.goodsPrice = price;
	}
	
	// �Żݼ۸�
    private Double goodsPreferentialPrice;
	public Double getGoodsPreferentialPrice() {
		return goodsPreferentialPrice;
	}
	public void setGoodsPreferentialPrice(Double newPrice) {
		this.goodsPreferentialPrice = newPrice;
	}	

	// �������
    private Integer goodsStockNumber;
	public Integer getGoodsStockNumber() {
		return goodsStockNumber;
	}
	public void setGoodsStockNumber(Integer number) {
		this.goodsStockNumber = number;
	}
	
	private String goodsImageAddress;  //ͼƬ��ַ
	public String getGoodsImageAddress() {
		return goodsImageAddress;
	}
	public void setGoodsImageAddress(String image) {
		this.goodsImageAddress = image;
	}	
	
	private String bigImageAddress;  //��ͼƬ��ַ
	public String getBigImageAddress() {
		return bigImageAddress;
	}
	public void setBigImageAddress(String image) {
		this.bigImageAddress = image;
	}
	
	private Date createTime = new Date();// �ϼ�ʱ��
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	private Boolean commend = false;// �Ƿ����Ƽ���Ʒ��Ĭ��ֵΪfalse��
	public Boolean getCommend() {
		return commend;
	}
	public void setCommend(Boolean commend) {
		this.commend = commend;
	}
	
	private Integer sellCount = 0;// ��������
	public Integer getSellCount() {
		return sellCount;
	}
	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}
}
