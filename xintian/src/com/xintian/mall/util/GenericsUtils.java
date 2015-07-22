package com.xintian.mall.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/**
 * ���͹�����
 */
public class GenericsUtils {
	/**
	 * ��ȡ���͵�����
	 * @param clazz
	 * @return Class
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Class getGenericType(Class clazz){
		Type genType = clazz.getGenericSuperclass();//�õ����͸���  
		Type[] types = ((ParameterizedType) genType).getActualTypeArguments();
		if (!(types[0] instanceof Class)) {
            return Object.class;   
        } 
		return (Class) types[0];
	}
	/**
	 * ��ȡ����������
	 * @param clazz
	 * @return �����
	 */
	@SuppressWarnings("rawtypes")
	public static String getGenericName(Class clazz){
		return clazz.getSimpleName();
	}
}
