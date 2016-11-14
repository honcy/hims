/*  
 * Copyright (c) 2015-2016 
 * 大连弘实科技有限公司  版权所有  
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved. 
 */
package com.honcy.hims.common.supcan.common;

import java.util.List;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import com.honcy.hims.common.supcan.common.fonts.Font;
import com.honcy.hims.common.supcan.common.properties.Properties;
import com.honcy.hims.common.utils.IdGen;

/**
 * 硕正Common
 *
 * 名称：Common
 * Created on  2016/11/14 - 19:35
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/14      rdinfo    初始版本
 */
public class Common {

    /**
     * 属性对象
     */
    @XStreamAlias("Properties")
    protected Properties properties;

    /**
     * 字体对象
     */
    @XStreamAlias("Fonts")
    protected List<Font> fonts;

    public Common() {
        properties = new Properties(IdGen.uuid());
        fonts = Lists.newArrayList(
                new Font("宋体", "134", "-12"),
                new Font("宋体", "134", "-13", "700"));
    }

    public Common(Properties properties) {
        this();
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List<Font> getFonts() {
        return fonts;
    }

    public void setFonts(List<Font> fonts) {
        this.fonts = fonts;
    }
}