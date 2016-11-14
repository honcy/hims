/*
 * Copyright(c) 2015-2016. DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
*/
package com.honcy.hims.modules.sys.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.honcy.hims.common.mapper.JsonMapper;
import com.honcy.hims.common.utils.CacheUtils;
import com.honcy.hims.common.utils.SpringContextHolder;
import com.honcy.hims.modules.sys.dao.DictDao;
import com.honcy.hims.modules.sys.entity.Dict;

/**
 * 字典工具类
 *
 * 名称：DictUtils
 * Created on  2016/11/14 15:29
 * 版本       修改时间      作者      修改内容
 * V1.0.1     2016/11/14      rdinfo    初始版本
 **/
public class DictUtils {

    private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);

    public static final String CACHE_DICT_MAP = "dictMap";

    public static String getDictLabel(String value, String type, String defaultValue){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
            for (Dict dict : getDictList(type)){
                if (type.equals(dict.getType()) && value.equals(dict.getValue())){
                    return dict.getLabel();
                }
            }
        }
        return defaultValue;
    }

    public static String getDictLabels(String values, String type, String defaultValue){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
            List<String> valueList = Lists.newArrayList();
            for (String value : StringUtils.split(values, ",")){
                valueList.add(getDictLabel(value, type, defaultValue));
            }
            return StringUtils.join(valueList, ",");
        }
        return defaultValue;
    }

    public static String getDictValue(String label, String type, String defaultLabel){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
            for (Dict dict : getDictList(type)){
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }

    public static List<Dict> getDictList(String type){
        @SuppressWarnings("unchecked")
        Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap==null){
            dictMap = Maps.newHashMap();
            for (Dict dict : dictDao.findAllList(new Dict())){
                List<Dict> dictList = dictMap.get(dict.getType());
                if (dictList != null){
                    dictList.add(dict);
                }else{
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }
            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<Dict> dictList = dictMap.get(type);
        if (dictList == null){
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    /**
     * 返回字典列表（JSON）
     * @param type
     * @return
     */
    public static String getDictListJson(String type){
        return JsonMapper.toJsonString(getDictList(type));
    }

}