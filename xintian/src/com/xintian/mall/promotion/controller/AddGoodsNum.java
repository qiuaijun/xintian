package com.xintian.mall.promotion.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.xintian.mall.promotion.dao.Counter2AddressDao;
import org.apache.commons.logging.Log;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aijun on 15/6/27.
 */
public class AddGoodsNum extends ActionSupport {
    private static final Log log = org.apache.commons.logging.LogFactory.getLog(AddGoodsNum.class);

    //预约人
    private String person;
    //预约电话
    private String phone;
    //预约地址
    private String address;
    //预约商品
    private String goods;
    //预约数量
    private int goods_num;
    //备注
    private String remarks;

    private Map<String, Object> address2Count=new HashMap<>();

    private Counter2AddressDao counter2AddressDao;


    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Map<String, Object> getAddress2Count() {
        return address2Count;
    }

    public void setAddress2Count(Map<String, Object> address2Count) {
        this.address2Count = address2Count;
    }

    public void setCounter2AddressDao(Counter2AddressDao counter2AddressDao) {
        this.counter2AddressDao = counter2AddressDao;
    }

    public String getAllAddressStatics() {
        address2Count.put("count", counter2AddressDao.getAllAddressStatics().get(address));
        address2Count.put("success", true);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        log.info("recevice one order of goods");
        counter2AddressDao.addNum(getAddress());
        counter2AddressDao.getAllAddressStatics();
        ServletContext servletContext = ServletActionContext.getServletContext();
        String realPath = servletContext.getRealPath("/");
        File bookPath = new File(realPath);
        if (!bookPath.exists()) {
            bookPath.createNewFile();
        }
        File bookfile = new File(realPath + "book.csv");
        if (!bookfile.exists()) {
            bookfile.createNewFile();
        }
        writeFile(bookfile);
        log.info(bookfile.getAbsoluteFile());
        return super.execute();
    }

    private void writeFile(File file) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write("test,dddd,ffff,eeeee,ggggg" + System.getProperty("line.separator"));
            fw.flush();
        } catch (Exception e) {
            log.error("write file error", e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
