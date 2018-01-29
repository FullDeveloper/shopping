package com.emed.shopping.interceptor;

import com.emed.shopping.dao.model.admin.user.ShopUser;
import com.emed.shopping.service.admin.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 周润斌
 * @Date: create in 上午 14:26 2018/1/26 0026
 * @Description:
 */
public class UpmsInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(UpmsInterceptor.class);

    @Autowired
    private UserService userService;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 过滤ajax
        if (null != httpServletRequest.getHeader("X-Requested-With") &&
                "XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))) {
            return true;
        }
        logger.info("设置用户信息");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        ShopUser query = new ShopUser();
        query.setUserName(username);
        ShopUser user = userService.selectOne(query);
        httpServletRequest.getSession().setAttribute("currentUser",user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
