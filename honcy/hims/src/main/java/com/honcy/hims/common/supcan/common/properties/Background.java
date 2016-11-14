/*  
 * Copyright (c) 2015-2016 
 * 大连弘实科技有限公司  版权所有  
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved. 
 */
package com.honcy.hims.common.supcan.common.properties;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import com.honcy.hims.common.supcan.annotation.common.properties.SupBackground;
import com.honcy.hims.common.utils.ObjectUtils;

/**
 * 硕正TreeList Properties Background
 *
 * 名称：Background
 * Created on  2016/11/14 - 19:39
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/14      rdinfo    初始版本
 */
@XStreamAlias("Background")
public class Background {

    /**
     * 背景颜色
     */
    @XStreamAsAttribute
    private String bgColor = "#FDFDFD";

    public Background() {

    }

    public Background(SupBackground supBackground) {
        this();
        ObjectUtils.annotationToObject(supBackground, this);
    }

    public Background(String bgColor) {
        this();
        this.bgColor = bgColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}