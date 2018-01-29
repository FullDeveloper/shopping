package com.emed.shopping.config.shiro;

import com.emed.shopping.dao.model.admin.user.ShopPermission;
import com.emed.shopping.dao.model.admin.user.ShopRole;
import com.emed.shopping.dao.model.admin.user.ShopUser;
import com.emed.shopping.service.admin.user.RoleService;
import com.emed.shopping.service.admin.user.UserService;
import com.emed.shopping.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 周润斌
 * @Date: create in 上午 12:54 2018/1/26 0026
 * @Description:
 */
public class CustomRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("授权方法：doGetAuthorizationInfo()");
        String username = (String) principalCollection.getPrimaryPrincipal();
        ShopUser query = new ShopUser();
        query.setUserName(username);
        ShopUser user = userService.selectOne(query);

        // 当前用户所有角色
        List<ShopRole> upmsRoles = userService.findUserRoleById(user.getId());
        Set<String> roles = new HashSet<>();
        for (ShopRole upmsRole : upmsRoles) {
            if (StringUtils.isNotBlank(upmsRole.getRoleCode())) {
                roles.add(upmsRole.getRoleCode());
            }
        }
        // 当前用户所有权限
        List<ShopPermission> upmsPermissions = userService.findUserPermissionById(user.getId());
        Set<String> permissions = new HashSet<>();
        for (ShopPermission upmsPermission : upmsPermissions) {
            if (StringUtils.isNotBlank(upmsPermission.getPermissionValue())) {
                permissions.add(upmsPermission.getPermissionValue());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("身份认证方法：doGetAuthenticationInfo()");
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        ShopUser query = new ShopUser();
        query.setUserName(username);
        // 从数据库获取对应用户名密码的用户
       ShopUser user = userService.selectOne(query);
       if (null == user) {
            throw new UnknownAccountException();
        }
        //e10adc3949ba59abbe56e057f20f883e
        //e10adc3949ba59abbe56e057f20f883e
        String userPwd = user.getPassword();
        String newPwd = MD5Util.md5(password).toLowerCase();
        if (!userPwd.equals(newPwd)) {
            throw new IncorrectCredentialsException();
        }
        if (user.getStatus() == 1) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user.getUserName(), password, getName());
    }
}
