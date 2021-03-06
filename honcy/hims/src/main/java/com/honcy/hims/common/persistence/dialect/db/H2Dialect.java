/*
 * Copyright (c) 2015-2016
 * 大连弘实科技有限公司  版权所有
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
 */
package com.honcy.hims.common.persistence.dialect.db;

import com.honcy.hims.common.persistence.dialect.Dialect;

/**
 * 名称：H2Dialect
 * Created on  2016/11/13 - 20:11
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/13      rdinfo    初始版本
 */
public class H2Dialect implements Dialect {

    public boolean supportsLimit() {
        return true;
    }

    /**
     * 将sql变成分页sql语句,提供将offset及limit使用占位符号(placeholder)替换.
     * <pre>
     * 如mysql
     * dialect.getLimitString("select * from user", 12, ":offset",0,":limit") 将返回
     * select * from user limit :offset,:limit
     * </pre>
     *
     * @param sql               实际SQL语句
     * @param offset            分页开始纪录条数
     * @param offsetPlaceholder 分页开始纪录条数－占位符号
     * @param limit             分页每页显示纪录条数
     * @param limitPlaceholder  分页纪录条数占位符号
     * @return 包含占位符的分页sql
     */
    private String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
        return sql + ((offset > 0) ? " limit " + limitPlaceholder + " offset "
                + offsetPlaceholder : " limit " + limitPlaceholder);
    }

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        return getLimitString(sql, offset, Integer.toString(offset), limit, Integer.toString(limit));
    }
}