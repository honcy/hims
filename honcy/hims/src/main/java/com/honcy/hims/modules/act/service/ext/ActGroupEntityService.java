/*
 * Copyright(c) 2015-2016. DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
*/
package com.honcy.hims.modules.act.service.ext;

import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import com.honcy.hims.common.utils.SpringContextHolder;
import com.honcy.hims.modules.act.utils.ActUtils;
import com.honcy.hims.modules.sys.entity.Role;
import com.honcy.hims.modules.sys.entity.User;
import com.honcy.hims.modules.sys.service.SystemService;

/**
 * Activiti Group Entity Service
 *
 * 名称：ActGroupEntityService
 * Created on  2016/11/14 16:00
 * 版本       修改时间      作者      修改内容
 * V1.0.1     2016/11/14      rdinfo    初始版本
 **/
@Service
public class ActGroupEntityService extends GroupEntityManager {

    private SystemService systemService;

    public SystemService getSystemService() {
        if (systemService == null){
            systemService = SpringContextHolder.getBean(SystemService.class);
        }
        return systemService;
    }

    public Group createNewGroup(String groupId) {
        return new GroupEntity(groupId);
    }

    public void insertGroup(Group group) {
        throw new RuntimeException("not implement method.");
    }

    public void updateGroup(GroupEntity updatedGroup) {
        throw new RuntimeException("not implement method.");
    }

    public void deleteGroup(String groupId) {
        throw new RuntimeException("not implement method.");
    }

    public GroupQuery createNewGroupQuery() {
        throw new RuntimeException("not implement method.");
    }

    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
        throw new RuntimeException("not implement method.");
    }

    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        throw new RuntimeException("not implement method.");
    }

    public List<Group> findGroupsByUser(String userId) {
        List<Group> list = Lists.newArrayList();
        User user = getSystemService().getUserByLoginName(userId);
        if (user != null && user.getRoleList() != null){
            for (Role role : user.getRoleList()){
                list.add(ActUtils.toActivitiGroup(role));
            }
        }
        return list;
    }

    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new RuntimeException("not implement method.");
    }

    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("not implement method.");
    }

}