/*
 * Copyright(c) 2015-2016. DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved.
*/
package com.honcy.hims.common.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ckfinder.connector.ConnectorServlet;

import com.honcy.hims.common.config.Global;
import com.honcy.hims.common.utils.FileUtils;
import com.honcy.hims.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.honcy.hims.modules.sys.utils.UserUtils;


/**
 * 名称：CKFinderConnectorServlet
 * Created on  2016/11/14 15:53
 * 版本       修改时间      作者      修改内容
 * V1.0.1     2016/11/14      rdinfo    初始版本
 **/
public class CKFinderConnectorServlet extends ConnectorServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        prepareGetResponse(request, response, false);
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        prepareGetResponse(request, response, true);
        super.doPost(request, response);
    }

    private void prepareGetResponse(final HttpServletRequest request,
                                    final HttpServletResponse response, final boolean post) throws ServletException {
        Principal principal = (Principal) UserUtils.getPrincipal();
        if (principal == null){
            return;
        }
        String command = request.getParameter("command");
        String type = request.getParameter("type");
        // 初始化时，如果startupPath文件夹不存在，则自动创建startupPath文件夹
        if ("Init".equals(command)){
            String startupPath = request.getParameter("startupPath");// 当前文件夹可指定为模块名
            if (startupPath!=null){
                String[] ss = startupPath.split(":");
                if (ss.length==2){
                    String realPath = Global.getUserfilesBaseDir() + Global.USERFILES_BASE_URL
                            + principal + "/" + ss[0] + ss[1];
                    FileUtils.createDirectory(FileUtils.path(realPath));
                }
            }
        }
        // 快捷上传，自动创建当前文件夹，并上传到该路径
        else if ("QuickUpload".equals(command) && type!=null){
            String currentFolder = request.getParameter("currentFolder");// 当前文件夹可指定为模块名
            String realPath = Global.getUserfilesBaseDir() + Global.USERFILES_BASE_URL
                    + principal + "/" + type + (currentFolder != null ? currentFolder : "");
            FileUtils.createDirectory(FileUtils.path(realPath));
        }
//		System.out.println("------------------------");
//		for (Object key : request.getParameterMap().keySet()){
//			System.out.println(key + ": " + request.getParameter(key.toString()));
//		}
    }

}