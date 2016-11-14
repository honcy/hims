/*  
 * Copyright (c) 2015-2016 
 * 大连弘实科技有限公司  版权所有  
 * DALIAN HONCY TECHNOLOGY CO.,LTD. All Rights Reserved. 
 */
package com.honcy.hims.modules.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.honcy.hims.common.service.BaseService;
import com.honcy.hims.common.utils.StringUtils;
import com.honcy.hims.common.utils.UserAgentUtils;

/**
 * 手机端视图拦截器
 *
 * 名称：MobileInterceptor
 * Created on  2016/11/14 - 19:28
 * 版本         修改时间      作者        修改内容
 * V1.0.1      2016/11/14      rdinfo    初始版本
 */
public class MobileInterceptor extends BaseService implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null){
            // 如果是手机或平板访问的话，则跳转到手机视图页面。
            if(UserAgentUtils.isMobileOrTablet(request) && !StringUtils.startsWithIgnoreCase(modelAndView.getViewName(), "redirect:")){
                modelAndView.setViewName("mobile/" + modelAndView.getViewName());
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }

}