/*
 * Copyright(c) 2015-2016. DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
*/
package com.honcy.hims.modules.sys.dao;

import com.honcy.hims.common.persistence.TreeDao;
import com.honcy.hims.common.persistence.annotation.MyBatisDao;
import com.honcy.hims.modules.sys.entity.Office;

/**
 * 机构DAO接口
 *
 * 名称：OfficeDao
 * Created on  2016/11/14 15:00
 * 版本       修改时间      作者      修改内容
 * V1.0.1     2016/11/14      rdinfo    初始版本
 **/
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {

}