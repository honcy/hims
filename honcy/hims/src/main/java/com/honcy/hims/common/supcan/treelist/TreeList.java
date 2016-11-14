/*  
 * Copyright (c) 2015-2016 
 * 大连弘实科技有限公司  版权所有  
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved. 
 */
package com.honcy.hims.common.supcan.treelist;

import java.util.List;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import com.honcy.hims.common.supcan.annotation.common.fonts.SupFont;
import com.honcy.hims.common.supcan.annotation.treelist.SupTreeList;
import com.honcy.hims.common.supcan.common.Common;
import com.honcy.hims.common.supcan.common.fonts.Font;
import com.honcy.hims.common.supcan.common.properties.Properties;

/**
 * 硕正TreeList
 *
 * 名称：TreeList
 * Created on  2016/11/14 - 19:33
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/14      rdinfo    初始版本
 */
@XStreamAlias("TreeList")
public class TreeList extends Common {

    /**
     * 列集合
     */
    @XStreamAlias("Cols")
    private List<Object> cols;

    public TreeList() {
        super();
    }

    public TreeList(Properties properties) {
        this();
        this.properties = properties;
    }

    public TreeList(SupTreeList supTreeList) {
        this();
        if (supTreeList != null){
            if (supTreeList.properties() != null){
                this.properties = new Properties(supTreeList.properties());
            }
            if (supTreeList.fonts() != null){
                for (SupFont supFont : supTreeList.fonts()){
                    if (this.fonts == null){
                        this.fonts = Lists.newArrayList();
                    }
                    this.fonts.add(new Font(supFont));
                }
            }
        }
    }

    public List<Object> getCols() {
        if (cols == null){
            cols = Lists.newArrayList();
        }
        return cols;
    }

    public void setCols(List<Object> cols) {
        this.cols = cols;
    }
}