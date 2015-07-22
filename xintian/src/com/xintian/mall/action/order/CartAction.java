package com.xintian.mall.action.order;

import java.util.Iterator;
import java.util.Set;

import com.xintian.mall.action.BaseAction;
import com.xintian.mall.model.order.OrderItem;
import com.xintian.mall.model.product.ProductInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * ���ﳵAction
 */
@Scope("prototype")
@Controller("cartAction")
public class CartAction extends BaseAction {
  private static final long serialVersionUID = 1L;
  // ��Ʒid
  private Integer productId;
  public Integer getProductId() {
	  return productId;
  }
  public void setProductId(Integer productId) {
	  this.productId = productId;
  }
  
  // �����仯��ʶ
  private String flag;
  public String getFlag() {
	  return flag;
  }
  public void setFlag(String flag) {
	  this.flag = flag;
  }
  
  // ���ﳵ�������Ʒ
  @Override
  public String add() throws Exception {
	if(productId != null && productId > 0){
	  // ��ȡ���ﳵ
	  Set<OrderItem> cart = getCart();
	  // �����ӵ���Ʒ�Ƿ���ͬһ����Ʒ
	  boolean same = false;
	  for (OrderItem item : cart) {
		if(item.getProductId() == productId){
			// ������ͬ����Ʒ����������
			item.setBuyNum(item.getBuyNum() + 1);
			same = true;
		}
	  }
	  // ����ͬһ����Ʒ
	  if(!same){
		OrderItem item = new OrderItem();
		ProductInfo product = productDao.load(productId);
		item.setProductId(product.getId());
		item.setProductName(product.getName());
		item.setProductPrice(product.getGoodsPrice());
		item.setProductPreferentialPrice(product.getGoodsPreferentialPrice());
		item.setImageAddress(product.getGoodsImageAddress());
		item.setProductCode(product.getGoodsCode());
		cart.add(item);
	  }
	  session.put("cart", cart);
	}
	return LIST;
  }
  // �鿴���ﳵ
  public String list() throws Exception {
	  return LIST;     //���ع��ﳵҳ��
  }
  
  // �޸Ĺ�������
  public String editNum() throws Exception {		
	Set<OrderItem> cart = getCart();// ��ȡ���ﳵ
	// �˴�ʹ��Iterator���������java.util.ConcurrentModificationException
	Iterator<OrderItem> it = cart.iterator();
	while(it.hasNext()){        //ʹ�õ����������Ʒ������Ŀ��Ϣ
	  OrderItem item = it.next();			
	  if(item.getProductId() == productId){
		// ������ͬ����Ʒ����������
		if(flag.equals("add")) 
		{
		  item.setBuyNum(item.getBuyNum() + 1);
		}
		else
		{
		  item.setBuyNum(item.getBuyNum() - 1);	
		}
	  }
	}
	session.put("cart", cart);  //����պ����Ϣ���·���Session��
	return LIST;                //���ع��ﳵҳ��
  }
  
  // �ӹ��ﳵ��ɾ����Ʒ
  public String delete() throws Exception {
	  Set<OrderItem> cart = getCart();    // ��ȡ���ﳵ
	  // �˴�ʹ��Iterator���������java.util.ConcurrentModificationException
	  Iterator<OrderItem> it = cart.iterator();
	  while(it.hasNext()){         //ʹ�õ����������Ʒ������Ŀ��Ϣ
		  OrderItem item = it.next();
		  if(item.getProductId() == productId){
			  it.remove();        //�Ƴ���Ʒ������Ŀ��Ϣ
		  }
	  }
	  session.put("cart", cart);  //����պ����Ϣ���·���Session��
	  return LIST;                //���ع��ﳵҳ��
  }
  // ��չ��ﳵ
  public String clear() throws Exception {
	  session.remove("cart");
	  return LIST;
  }
}