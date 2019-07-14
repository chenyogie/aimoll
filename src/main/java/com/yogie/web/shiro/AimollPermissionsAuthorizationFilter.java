package com.yogie.web.shiro;


import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: aimoll
 * @Date: 2019/7/13 19:25
 * @Author: Chenyogie
 * @Description: 自定义权限过滤器，解决ajax请求返回undefined问题
 *
 * PermissionsAuthorizationFilter是shiro自己的过滤器
 * 自定义的需要继承自这个过滤器
 */
public class AimollPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        //获取主体
        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            //如果为主体为空，重定向到登录页面
            this.saveRequestAndRedirectToLogin(request, response);
        } else {
            //如果主体不为空，拿到http请求和响应
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            //获取指定的请求头
            String header = req.getHeader("X-Requested-With");
            if("XMLHttpRequest".equals(header)){
                //设置返回格式为json格式
                resp.setContentType("application/json;charset=utf-8");
                resp.getWriter().write("{\"success\":false,\"msg\":\"权限不够\"}");
            }else{
                //如果是普通的请求，当前访问的资源没有权限时，就跳转提示没有权限
                String unauthorizedUrl = this.getUnauthorizedUrl();
                if (StringUtils.hasText(unauthorizedUrl)) {
                    WebUtils.issueRedirect(request, response, unauthorizedUrl);
                } else {
                    WebUtils.toHttp(response).sendError(401);
                }
            }
        }
        return false;
    }
}
