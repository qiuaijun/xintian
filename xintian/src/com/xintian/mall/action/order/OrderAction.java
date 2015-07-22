package com.xintian.mall.action.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.xintian.mall.action.BaseAction;
import com.xintian.mall.model.PageModel;
import com.xintian.mall.model.order.Order;
import com.xintian.mall.model.order.OrderItem;
import com.xintian.mall.model.product.ProductInfo;
import com.xintian.mall.util.StringUitl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
/**
 * ����Action
 */
@Scope("prototype")
@Controller("orderAction")
public class OrderAction extends BaseAction implements ModelDriven<Order>{
  private static final long serialVersionUID = 1L;
  
  // ����
  private Order order = new Order();
  public Order getOrder() {
	  return order;
  }
  public void setOrder(Order order) {
	  this.order = order;
  }
  
  private PageModel<Order> pageModel;      // ��ҳ���
  public PageModel<Order> getPageModel() {
	  return pageModel;
  }
  public void setPageModel(PageModel<Order> pageModel) {
	  this.pageModel = pageModel;
  }
  @Override
  public Order getModel() {
	  return order;
  }
  /**
   * �¶���
   */
  public String add() throws Exception {
	order.setName(getLoginCustomer().getUsername());
	order.setAddress(getLoginCustomer().getAddress());
	order.setPhone(getLoginCustomer().getPhone());
	return ADD;
  }
  /**
   * ����ȷ��
   * @return
   * @throws Exception
   */
  public String confirm() throws Exception {
	  return "confirm";     //���ض���ȷ��ҳ��
  }
  /**
   * ���������浽��ݱ�
   * @return String
   * @throws Exception
   */
  public String save() throws Exception {
	if(getLoginCustomer() != null){              //����û��ѵ�¼
		String code= StringUitl.createOrderCode();
		order.setOrderCode(code);                // ���ö�����
		order.setCustomer(getLoginCustomer());   // ���������û�
		Set<OrderItem> cart = getCart();         // ��ȡ���ﳵ
		if(cart.isEmpty()){                      //�ж���Ŀ��Ϣ�Ƿ�Ϊ��
			return ERROR;                       //���ض�����Ϣ������ʾҳ��
		}
		// ���ν����¶������е���Ʒ����������
		for(OrderItem item : cart){                   //�����ﳵ�еĶ�����Ŀ��Ϣ
			item.setOrder(order);
			Integer productId = item.getProductId();   //��ȡ��ƷID
			ProductInfo product = productDao.load(productId);   //װ����Ʒ����
			product.setSellCount(product.getSellCount() + item.getBuyNum());  //������Ʒ��������
			productDao.update(product);   //�޸���Ʒ��Ϣ
		}
		order.setOrderItems(cart);          // ���ö�����
		order.setOrderState("���ڴ�����");  // ���ö���״̬
		Double totalPrice = 0.0;              // �����ܶ�ı���
		for (OrderItem orderItem : cart) {    //�����ﳵ�еĶ�����Ŀ��Ϣ
			totalPrice += orderItem.getProductPreferentialPrice() * orderItem.getBuyNum();//��Ʒ�Żݵ���*��Ʒ����
		}
		order.setTotalPrice(totalPrice);      //���ö������ܼ۸�
		orderDao.save(order);                 //���涩����Ϣ
		session.remove("cart");               // ��չ��ﳵ
	}
	return findByCustomer();                  //���ؿͻ�������ѯ�ķ���
  }
  /**
   * ��ѯ�ͻ�����
   * @return String
   * @throws Exception
   */
  public String findByCustomer() throws Exception {
	if(getLoginCustomer() != null){                //����û��ѵ�¼
		String where = "where customer.id = ?";    //���û�id����Ϊ��ѯ����
		Object[] queryParams = {getLoginCustomer().getId()};           //������������
		Map<String, String> orderby = new HashMap<String, String>(1);  //����Map����
		orderby.put("createTime", "desc");//����������������ʽ
		pageModel = orderDao.find(where, queryParams, orderby , pageNo, pageSize); //ִ�в�ѯ����
	}
	return LIST;   //���ض����б�ҳ��
  }	
}
