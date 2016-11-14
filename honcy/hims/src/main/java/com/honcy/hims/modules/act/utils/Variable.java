/*  
 * Copyright (c) 2015-2016 
 * 大连弘实科技有限公司  版权所有  
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved. 
 */
package com.honcy.hims.modules.act.utils;

import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;

import com.honcy.hims.common.utils.StringUtils;

/**
 * 流程变量对象
 *
 * 名称：Variable
 * Created on  2016/11/14 - 19:10
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/14      rdinfo    初始版本
 */
public class Variable {

    private Map<String, Object> map = Maps.newHashMap();

    private String keys;
    private String values;
    private String types;

    public Variable (){

    }

    public Variable (Map<String, Object> map){
        this.map = map;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @JsonIgnore
    public Map<String, Object> getVariableMap() {

        ConvertUtils.register(new DateConverter(), java.util.Date.class);

        if (StringUtils.isBlank(keys)) {
            return map;
        }

        String[] arrayKey = keys.split(",");
        String[] arrayValue = values.split(",");
        String[] arrayType = types.split(",");
        for (int i = 0; i < arrayKey.length; i++) {
            String key = arrayKey[i];
            String value = arrayValue[i];
            String type = arrayType[i];

            Class<?> targetType = Enum.valueOf(PropertyType.class, type).getValue();
            Object objectValue = ConvertUtils.convert(value, targetType);
            map.put(key, objectValue);
        }
        return map;
    }

    public Map<String, Object> getMap() {
        return map;
    }

}