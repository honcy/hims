/*
 * Copyright(c) 2015-2016. DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
*/
package com.honcy.hims.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.honcy.hims.common.persistence.TreeEntity;

/**
 * 区域Entity
 *
 * 名称：Area
 * Created on  2016/11/14 14:40
 * 版本       修改时间      作者      修改内容
 * V1.0.1     2016/11/14      rdinfo    初始版本
 **/
public class Area extends TreeEntity<Area> {

    private static final long serialVersionUID = 1L;
    private String code; 	// 区域编码
    private String type; 	// 区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）

    public Area(){
        super();
        this.sort = 30;
    }

    public Area(String id){
        super(id);
    }

    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    @Length(min=1, max=1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Length(min=0, max=100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return name;
    }
}