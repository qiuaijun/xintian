package com.xintian.mall.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * �ַ�����
 */
public class StringUitl {
  public static Random random = new Random();
  /**
   * ��ȡ��ǰʱ���ַ�
   * @return ��ǰʱ���ַ�
   */
  public static String getStringDate(){
	  Date date = new Date();//��ȡ��ǰϵͳʱ��
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//���ø�ʽ����ʽ
	  return sdf.format(date);//���ظ�ʽ�����ʱ��
  }
  
  /**
   * ��ɶ�����
   * @return ������
   */
  public static String createOrderCode(){
	  StringBuffer sb = new StringBuffer();//�����ַ����
	  sb.append(getStringDate());//���ַ��������ӵ�ǰϵͳʱ��
	  for (int i = 0; i < 3; i++) {//������3λ��
		  sb.append(random.nextInt(9));//�������ɵ�������ӵ��ַ������
	  }
	  return sb.toString();//�����ַ�
  }

  /**
   * ��֤�ַ����Ч��
   * @param s ��֤�ַ�
   * @return �Ƿ���Ч�Ĳ���ֵ
   */
  public static boolean validateString(String s){
	  if(s != null && s.trim().length() > 0){//����ַ�Ϊ�շ���true
		  return true;
	  }
	  return false;//�ַ�Ϊ�շ���false
  }
  /**
   * ��֤����������Ч��
   * @param f �������
   * @return �Ƿ���Ч�Ĳ���ֵ
   */
  public static boolean validateFloat(Float f){
	  try {
		  if(f != null && f > 0){
			  return true;
		  }
	  } catch (Exception e) {}
	  return false;
  }
}

