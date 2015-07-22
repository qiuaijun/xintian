package com.xintian.mall.dao;

import com.xintian.mall.model.PageModel;

import java.io.Serializable;
import java.util.Map;


public interface BaseDao<T> {
  //�1�7�1�7�1�7�1�7�1�3�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7
  public void save(Object obj);              //�1�7�1�7�1�7�1�7�1�7�1�7�1�7
  public void saveOrUpdate(Object obj);      //�1�7�1�7�1�7�1�7�1�7�1�7�1�0�1�7�1�7�1�7�1�7
  public void update(Object obj);            //�1�7�1�0�1�7�1�7�1�7�1�7
  public void delete(Serializable... ids);   //�0�1�1�7�1�7�1�7�1�7�1�7
  public T get(Serializable entityId);       //�1�7�1�7�1�7�1�7�0�6�1�7�1�7�1�7�1�7�1�7
  public T load(Serializable entityId);       //�1�7�1�7�1�7�1�7�0�6�1�7�1�7�1�7�1�7�1�7
  public Object uniqueResult(String hql, Object[] queryParams); //�0�0�1�7�1�7hql�1�7�1�7�1�7�1�7�1�7�1�7
  //�1�7�1�7�0�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7
  public long getCount();//�1�7�1�7�0�0�1�7�1�7�0�4�1�7�1�7�1�7�1�7
  public PageModel<T> find(int pageNo, int maxResult);//�1�7�1�7�0�0�1�7�1�7�0�7�1�7�1�7�1�7�1�7
  public PageModel<T> find(int pageNo, int maxResult, String where, Object[] queryParams);//�1�7�1�7�1�7�1�7�1�7�1�7�0�4�1�7�1�7�0�7�1�7�1�7�1�7�1�7
  public PageModel<T> find(int pageNo, int maxResult, Map<String, String> orderby);//�1�7�1�7�0�8�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�7�1�7�1�7�1�7�1�7
  public PageModel<T> find(String where, Object[] queryParams,
                           Map<String, String> orderby, int pageNo, int maxResult);//�1�7�1�7�0�8�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�7�1�7�1�7�1�7�1�7�1�7�1�7�0�9�1�7�0�7�1�7�1�7�1�7�1�7
}
