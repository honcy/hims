/*  
 * Copyright (c) 2015-2016 
 * 大连弘实科技有限公司  版权所有  
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved. 
 */
package com.honcy.hims.modules.act.utils;

import java.util.Date;

/**
 * 属性数据类型
 *
 * 名称：PropertyType
 * Created on  2016/11/14 - 19:12
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/14      rdinfo    初始版本
 */
public enum PropertyType {

    S(String.class),
    I(Integer.class),
    L(Long.class),
    F(Float.class),
    N(Double.class),
    D(Date.class),
    SD(java.sql.Date.class),
    B(Boolean.class);

    private Class<?> clazz;

    private PropertyType(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getValue() {
        return clazz;
    }
}