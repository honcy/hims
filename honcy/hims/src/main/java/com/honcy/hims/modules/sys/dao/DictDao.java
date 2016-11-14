/*
 * Copyright(c) 2015-2016. DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
*/
package com.honcy.hims.modules.sys.dao;

import java.util.List;

import com.honcy.hims.common.persistence.CrudDao;
import com.honcy.hims.common.persistence.annotation.MyBatisDao;
import com.honcy.hims.modules.sys.entity.Dict;

/**
 * 字典DAO接口
 *
 * 名称：DictDao
 * Created on  2016/11/14 15:28
 * 版本       修改时间      作者      修改内容
 * V1.0.1     2016/11/14      rdinfo    初始版本
 **/
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

    public List<String> findTypeList(Dict dict);

}