package com.xintian.mall.model.user;

import java.io.Serializable;
/**
 * ��ͨ�û�
 */
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;// �û�ID
	private String username;// �û���
	private String password ;// ����
	private String realname;// ��ʵ����	  
	private String address;// סַ
	private String email;	 // Email����
	private String phone;// ��ϵ�绰
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}  
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String name){
		this.username=name;
	} 
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	} 	
	public String getRealname() {
		  return realname;
	  }
	public void setRealname(String name) {
		this.realname = name;
	}
	
	public String getAddress() {
		  return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}		
		
	public String getEmail(){
		return email;
	}
	public void setEmail(String mail){
		this.email=mail;
	} 
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}