package com.xintian.mall.dao.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xintian.mall.dao.DaoSupport;
import com.xintian.mall.model.PageModel;
import com.xintian.mall.model.product.ProductInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
@Transactional
public class ProductDaoImpl extends DaoSupport<ProductInfo> implements ProductDao {
  /**
   * ��ѯ�Ƽ���Ʒ��ǰ10�������ϼ�ʱ�併������
   */
  @Override
  @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
  public List<ProductInfo> findCommend() {
	  String where = "where commend=?";
	  Object[] parames = {true};
	  Map<String, String> orderby = new HashMap<String, String>();
	  orderby.put("createTime", "desc");
	  PageModel<ProductInfo> pageModel = find(where,parames,orderby,1,10);
	  return pageModel.getList();
  }

}

