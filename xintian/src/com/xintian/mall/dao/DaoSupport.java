package com.xintian.mall.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.xintian.mall.model.PageModel;
import com.xintian.mall.util.GenericsUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.orm.hibernate4.HibernateCallback;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao?????
 * @param <T>
 */
@Transactional
@SuppressWarnings("unchecked")
public class DaoSupport<T> implements BaseDao<T>{
	// ?????????
	protected Class<T> entityClass = GenericsUtils.getGenericType(this.getClass());
	/**
	 * ???Session????
	 * @return
	 */
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	/**
	 * ????save()??????????????????
	 */
	@Override
	public void save(Object obj) {
		getSession().save(obj);
	}
	@Override
	public void saveOrUpdate(Object obj) {
		getSession().saveOrUpdate(obj);
	}
	/**
	 * ????update()?????????????????
	 */
	@Override
	public void update(Object obj) {
		getSession().update(obj);
	}
	@Override
	public void delete(Serializable ... ids) {
		for (Serializable id : ids) {
			T t = (T) getSession().load(this.entityClass, id);
			getSession().delete(t);
		}
	}
	/**
	 * ????get()????????????????????????
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public T get(Serializable entityId) {
		return (T) getSession().get(this.entityClass, entityId);
	}
	/**
	 * ????load()????????????????????????
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public T load(Serializable entityId) {
		return (T) getSession().load(this.entityClass, entityId);
	}
	/**
	 * ????HQL????????????
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Object uniqueResult(final String hql,final Object[] queryParams) {
		Query query=getSession().createQuery(hql);
		setQueryParams(query, queryParams);//???¨°??????
		return query.uniqueResult();
	}
	/**
	 * ??query?§Ö?????
	 * @param query
	 * @param queryParams
	 */
	protected void setQueryParams(Query query, Object[] queryParams){
		if(queryParams!=null && queryParams.length>0){
			for(int i=0; i<queryParams.length; i++){
				query.setParameter(i, queryParams[i]);
			}
		}
	}
	/**
	 * ?????????????????
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public long getCount() {
		String hql = "select count(*) from " + GenericsUtils.getGenericName(this.entityClass);
		return (Long)uniqueResult(hql,null);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageModel<T> find(final int pageNo, int maxResult) {
		return find(null, null, null, pageNo, maxResult);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageModel<T> find(int pageNo, int maxResult,
			Map<String, String> orderby) {
		return find(null, null, orderby, pageNo, maxResult);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageModel<T> find(int pageNo, int maxResult, String where,
			Object[] queryParams) {
		return find(where, queryParams, null, pageNo, maxResult);
	}
	/**
	 * ??????
	 * @param where ???????
	 * @param queryParams hql?????
	 * @param orderby ????
	 * @param pageNo ????
	 * @param maxResult ??????????
	 * return PageModel
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageModel<T> find(final String where, final Object[] queryParams,
			final Map<String, String> orderby, final int pageNo,
			final int maxResult) {
		final PageModel<T> pageModel = new PageModel<T>();   //?????????
		pageModel.setPageNo(pageNo);                         //?????????
		pageModel.setPageSize(maxResult);                     //??????????????
		String hql = new StringBuffer().append("from ")       //???form???
		.append(GenericsUtils.getGenericName(entityClass))    //??????????
		.append(" ")                                          //?????
		.append(where == null ? "" : where)  //???where?null???????,??????where
		.append(createOrderBy(orderby))                     //???????????????
		.toString();                                        //???????
		Query query = getSession().createQuery(hql);        //??§Ó??
		setQueryParams(query,queryParams);                  //??????
		List<T> list = null;                                //????List????
		// ???maxResult<0??????????
		if(maxResult < 0 && pageNo < 0){
		list = query.list();              //????????????List????
		}else{
		list = query.setFirstResult(getFirstResult(pageNo, maxResult))//???¡Â?????¦Ë??
				.setMaxResults(maxResult)//???????????????
				.list();//????????????List????
		//?????????????HQL???
		hql = new StringBuffer().append("select count(*) from ")        //???HQL???
					.append(GenericsUtils.getGenericName(entityClass))  //??????????
					.append(" ")                                        //?????
					.append(where == null ? "" : where)//???where?null???????,??????where
					.toString();                    //???????
		query = getSession().createQuery(hql);      //??§Ó??
		setQueryParams(query,queryParams);          //????HQL????
		int totalRecords = ((Long) query.uniqueResult()).intValue();  //???????
		pageModel.setTotalRecords(totalRecords);                      //??????????
		}
		pageModel.setList(list);                   //???????list???????????????		
		return pageModel;                          //??????????????
	}
	/**
	 * ??????????§ß??????¦Ë??
	 * @param pageNo ????
	 * @param maxResult ????????????
	 * @return ???¦Ë??
	 */
	protected int getFirstResult(int pageNo,int maxResult){
		int firstResult = (pageNo-1) * maxResult;
		return firstResult < 0 ? 0 : firstResult;
	}
	/**
	 * ????????hql???
	 * @param orderby
	 * @return ???????
	 */
	protected String createOrderBy(Map<String, String> orderby){
		StringBuffer sb = new StringBuffer("");
		if(orderby != null && orderby.size() > 0){
			sb.append(" order by ");
			for(String key : orderby.keySet()){
				sb.append(key).append(" ").append(orderby.get(key)).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
