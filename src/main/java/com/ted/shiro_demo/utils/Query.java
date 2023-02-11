package com.ted.shiro_demo.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

/**
 * 查询参数
 *
 */
public class Query<T> {
    /**
     * map.put("page",1);
     * map.put("limit",10)
     * map.put("order","asc")
     * map.put("sidx","id")
     */
    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final String ORDER_FIELD = "sidx";
    private static final String ORDER = "order";
    private static final String ASC = "asc";

    public IPage<T> getPage(Map<String, Object> params) {
        return this.getPage(params, null, false);
    }

    public IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if(params.get(PAGE) != null){
            curPage = Long.parseLong(String.valueOf(params.get(PAGE)));
        }
        if(params.get(LIMIT) != null){
            limit = Long.parseLong(String.valueOf(params.get(LIMIT)));
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //分页参数
        params.put(PAGE, page);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
//        String orderField = SQLFilter.sqlInject((String)params.get(ORDER_FIELD));
//        String order = (String)params.get(ORDER);
//
//
//        //前端字段排序
//        if(StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)){
//            if(ASC.equalsIgnoreCase(order)) {
//                return  page.addOrder(OrderItem.asc(orderField));
//            }else {
//                return page.addOrder(OrderItem.desc(orderField));
//            }
//        }
//
//        //没有排序字段，则不排序
//        if(StringUtils.isBlank(defaultOrderField)){
//            return page;
//        }
//
//        //默认排序
//        if(isAsc) {
//            page.addOrder(OrderItem.asc(defaultOrderField));
//        }else {
//            page.addOrder(OrderItem.desc(defaultOrderField));
//        }

        return page;
    }
}
 
