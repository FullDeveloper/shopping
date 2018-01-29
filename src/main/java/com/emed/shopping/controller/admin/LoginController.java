package com.emed.shopping.controller.admin;

import com.emed.shopping.base.BaseResult;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:45 2018/1/26 0026
 * @Description:
 */
@RequestMapping(value = "/sso")
@Controller
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        if (StringUtils.isBlank(username)) {
            return new BaseResult(302, "帐号不能为空！", null);
        }
        if (StringUtils.isBlank(password)) {
            return new BaseResult(303, "密码不能为空！", null);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            if (BooleanUtils.toBoolean(rememberMe)) {
                usernamePasswordToken.setRememberMe(true);
            } else {
                usernamePasswordToken.setRememberMe(false);
            }
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            return new BaseResult(4,"账号或密码错误", null);
        } catch (IncorrectCredentialsException e) {
            return new BaseResult(5,"账号或密码错误", null);
        } catch (LockedAccountException e) {
            return new BaseResult(6,"账号已锁定", null);
        }
        return BaseResult.ok("登录成功",null);
    }
}
