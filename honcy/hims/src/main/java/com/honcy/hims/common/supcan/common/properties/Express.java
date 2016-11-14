/*  
 * Copyright (c) 2015-2016 
 * 大连弘实科技有限公司  版权所有  
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved. 
 */
package com.honcy.hims.common.supcan.common.properties;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

import com.honcy.hims.common.supcan.annotation.common.properties.SupExpress;
import com.honcy.hims.common.utils.ObjectUtils;

/**
 * 硕正TreeList Properties Express
 *
 * 名称：Express
 * Created on  2016/11/14 - 19:40
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/14      rdinfo    初始版本
 */
@XStreamAlias("Express")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = {"text"})
public class Express {

    /**
     * 是否自动按列的引用关系优化计算顺序  默认值true
     */
    @XStreamAsAttribute
    private String isOpt;

    /**
     * 文本
     */
    private String text;

    public Express() {

    }

    public Express(SupExpress supExpress) {
        this();
        ObjectUtils.annotationToObject(supExpress, this);
    }

    public Express(String text) {
        this.text = text;
    }

    public Express(String name, String text) {
        this(name);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIsOpt() {
        return isOpt;
    }

    public void setIsOpt(String isOpt) {
        this.isOpt = isOpt;
    }
}