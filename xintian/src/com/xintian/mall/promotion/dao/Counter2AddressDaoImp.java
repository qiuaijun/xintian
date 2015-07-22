package com.xintian.mall.promotion.dao;

import org.apache.commons.logging.Log;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aijun on 15/7/3.
 */
public class Counter2AddressDaoImp implements Counter2AddressDao {
    private static final Log log = org.apache.commons.logging.LogFactory.getLog(Counter2AddressDaoImp.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void addNum(String address) {
        String querySql = "select count from address_statistics where addressname = ?";
        List<Map<String, Object>> queryForList = jdbcTemplateObject.queryForList(querySql,
                new Object[]{address});
        System.out.println(queryForList.toString());
        int count = 0;
        if (queryForList.size() == 0) {
            //没有该地址信息，因此需要初始化为 1；

            count = 1;
        } else {
            Map address2Count = queryForList.get(0);
            Integer tmp = (Integer) address2Count.get("count");
            count = tmp.intValue() + 1;
        }
        String addSql = "insert into address_statistics values(?,?)";
        String delSql = "delete from address_statistics where addressname=?";
        jdbcTemplateObject.update(delSql, address);
        jdbcTemplateObject.update(addSql, address, count);
    }


    @Override
    public Map<String, String> getAllAddressStatics() {
        String querySql = "select AddressName,count from address_statistics ";
        List<Map<String, Object>> queryForList = jdbcTemplateObject.queryForList(querySql);
        Map<String, String> queryForMap = new HashMap<>();
        for (int i = 0; i < queryForList.size(); i++) {
            Map<String, Object> tmpMap = queryForList.get(i);
            queryForMap.put((String) tmpMap.get("AddressName"), tmpMap.get("count").toString());
        }

        return queryForMap;
    }
}
