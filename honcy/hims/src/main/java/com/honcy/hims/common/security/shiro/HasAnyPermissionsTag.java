/*  
 * Copyright (c) 2015-2016 
 * 大连弘实科技有限公司  版权所有  
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved. 
 */
package com.honcy.hims.common.security.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * 名称：HasAnyPermissionsTag
 * Created on  2016/11/13 - 14:21
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/13      rdinfo    初始版本
 */
public class HasAnyPermissionsTag extends PermissionTag {

    private static final long serialVersionUID = 1L;
    private static final String PERMISSION_NAMES_DELIMETER = ",";

    @Override
    protected boolean showTagBody(String permissionNames) {
        boolean hasAnyPermission = false;

        Subject subject = getSubject();

        if (subject != null) {
            // Iterate through permissions and check to see if the user has one of the permissions
            for (String permission : permissionNames.split(PERMISSION_NAMES_DELIMETER)) {

                if (subject.isPermitted(permission.trim())) {
                    hasAnyPermission = true;
                    break;
                }

            }
        }

        return hasAnyPermission;
    }
}
