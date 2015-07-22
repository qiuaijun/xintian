package com.xintian.mall.action.product;

import java.util.HashMap;
import java.util.Map;

import com.xintian.mall.action.BaseAction;
import com.xintian.mall.image.ImageUtils;
import com.xintian.mall.model.PageModel;
import com.xintian.mall.model.product.ProductInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

/**
 * ��ƷAction
 */
@Scope("prototype")
@Controller("productAction")
public class ProductAction extends BaseAction implements ModelDriven<ProductInfo> {
    private static final long serialVersionUID = 1L;
    // 分页
    private PageModel<ProductInfo> pageModel;

    public PageModel<ProductInfo> getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel<ProductInfo> pageModel) {
        this.pageModel = pageModel;
    }

    // 商品对象
    private ProductInfo product = new ProductInfo();

    public ProductInfo getProduct() {
        return product;
    }

    public void setProduct(ProductInfo product) {
        this.product = product;
    }

    //实现继承的抽象方法
    @Override
    public ProductInfo getModel() {
        return product;
    }

    /**
     * 推荐商品
     *
     * @return
     * @throws Exception
     */
    public String findCommendProduct() throws Exception {
        Map<String, String> orderby = new HashMap<String, String>();//定义Map集合
        orderby.put("createTime", "desc");     //为Map集合赋值
        String where = "where commend = ?";    //设置条件语句
        Object[] queryParams = {true};         //设置参数值
        pageModel = productDao.find(where, queryParams, orderby, pageNo, pageSize);//执行查询方法

//        if (pageModel != null && pageModel.getList().size() > 0) {
//            for (ProductInfo p : pageModel.getList()) {
//                p.setBigImageAddress(ImageUtils.getImageUrl(p.getBigImageAddress()));
//                p.setGoodsImageAddress(ImageUtils.getImageUrl(p.getGoodsImageAddress()));
//            }
//        }

        return "list";                         //返回商品列表页面
    }

    /**
     * 根据id查看商品信息
     *
     * @return String
     * @throws Exception
     */
    public String select() throws Exception {
        if (product.getId() != null && product.getId() > 0) {
            product = productDao.get(product.getId());
            productDao.update(product);
        }
        return SELECT;
    }

    /**
     * 根据名称模糊查询
     *
     * @return String
     * @throws Exception
     */
    public String findByName() throws Exception {
        if (product.getName() != null) {
            String where = "where name like ?";                      //查询的条件语句
            Object[] queryParams = {"%" + product.getName() + "%"};  //为参数赋值
            pageModel = productDao.find(pageNo, pageSize, where, queryParams);  //执行查询方法
        }
        return LIST;  //返回列表首页
    }

    /**
     * 增加商品
     *
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        if (product.getName() != null) {
            productDao.save(product);
        }
        return ADD;
    }
}
