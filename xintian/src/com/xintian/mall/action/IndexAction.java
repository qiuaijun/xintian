package com.xintian.mall.action;
import java.util.List;

import com.xintian.mall.model.product.ProductInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("prototype")
@Controller("indexAction")
public class IndexAction extends BaseAction {
	private static final long serialVersionUID = 1L;	
	// �Ƽ���Ʒ
	private List<ProductInfo> product_commend;
	public List<ProductInfo> getProduct_commend() {
		return product_commend;
	}
	public void setProduct_commend(List<ProductInfo> productCommend) {
		product_commend = productCommend;
	}	
	@Override
	public String execute() throws Exception {
		// ��ѯ�Ƽ�����Ʒ
		product_commend = productDao.findCommend();
		return SUCCESS;
	}
}
