/*
 * Copyright (c) 2015-2016
 * 大连弘实科技有限公司  版权所有
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
 */
package com.honcy.hims.common.persistence.dialect.db;

import com.honcy.hims.common.persistence.dialect.Dialect;

/**
 * MSSQLServer 数据库实现分页方言
 *
 * 名称：SQLServerDialect
 * Created on  2016/11/13 - 20:11
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/13      rdinfo    初始版本
 */
public class SQLServerDialect implements Dialect {

    public boolean supportsLimit() {
        return true;
    }

    static int getAfterSelectInsertPoint(String sql) {
        int selectIndex = sql.toLowerCase().indexOf("select");
        final int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
        return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
    }

    public String getLimitString(String sql, int offset, int limit) {
        return getLimit(sql, offset, limit);
    }

    /**
     * 将sql变成分页sql语句,提供将offset及limit使用占位符号(placeholder)替换.
     * <pre>
     * 如mysql
     * dialect.getLimitString("select * from user", 12, ":offset",0,":limit") 将返回
     * select * from user limit :offset,:limit
     * </pre>
     *
     * @param sql    实际SQL语句
     * @param offset 分页开始纪录条数
     * @param limit  分页每页显示纪录条数
     * @return 包含占位符的分页sql
     */
    public String getLimit(String sql, int offset, int limit) {
        if (offset > 0) {
            throw new UnsupportedOperationException("sql server has no offset");
        }
        return new StringBuffer(sql.length() + 8)
                .append(sql)
                .insert(getAfterSelectInsertPoint(sql), " top " + limit)
                .toString();
    }


}
