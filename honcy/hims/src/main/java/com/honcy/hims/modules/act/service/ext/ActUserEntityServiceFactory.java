/*
 * Copyright(c) 2015-2016. DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
*/
package com.honcy.hims.modules.act.service.ext;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Activiti User Entity Service Factory
 *
 * 名称：ActUserEntityServiceFactory
 * Created on  2016/11/14 15:58
 * 版本       修改时间      作者      修改内容
 * V1.0.1     2016/11/14      rdinfo    初始版本
 **/
public class ActUserEntityServiceFactory implements SessionFactory {

    @Autowired
    private ActUserEntityService actUserEntityService;

    public Class<?> getSessionType() {
        // 返回原始的UserIdentityManager类型
        return UserIdentityManager.class;
    }

    public Session openSession() {
        // 返回自定义的UserEntityManager实例
        return actUserEntityService;
    }

}