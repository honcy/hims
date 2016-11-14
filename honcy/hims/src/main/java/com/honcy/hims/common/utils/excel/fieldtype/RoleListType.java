/*
 * Copyright(c) 2015-2016. DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
*/
package com.honcy.hims.common.utils.excel.fieldtype;

import java.util.List;

import com.google.common.collect.Lists;

import com.honcy.hims.common.utils.StringUtils;
import com.honcy.hims.common.utils.Collections3;
import com.honcy.hims.common.utils.SpringContextHolder;
import com.honcy.hims.modules.sys.entity.Role;
import com.honcy.hims.modules.sys.service.SystemService;

/**
 * 字段类型转换
 *
 * 名称：RoleListType
 * Created on  2016/11/14 13:45
 * 版本       修改时间      作者      修改内容
 * V1.0.1     2016/11/14      rdinfo    初始版本
 **/
public class RoleListType {

    private static SystemService systemService = SpringContextHolder.getBean(SystemService.class);

    /**
     * 获取对象值（导入）
     */
    public static Object getValue(String val) {
        List<Role> roleList = Lists.newArrayList();
        List<Role> allRoleList = systemService.findAllRole();
        for (String s : StringUtils.split(val, ",")){
            for (Role e : allRoleList){
                if (StringUtils.trimToEmpty(s).equals(e.getName())){
                    roleList.add(e);
                }
            }
        }
        return roleList.size()>0?roleList:null;
    }

    /**
     * 设置对象值（导出）
     */
    public static String setValue(Object val) {
        if (val != null){
            @SuppressWarnings("unchecked")
            List<Role> roleList = (List<Role>)val;
            return Collections3.extractToString(roleList, "name", ", ");
        }
        return "";
    }

}