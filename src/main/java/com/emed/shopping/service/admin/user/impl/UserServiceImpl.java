package com.emed.shopping.service.admin.user.impl;

import com.emed.shopping.base.BaseServiceImpl;
import com.emed.shopping.dao.mapper.admin.user.ShopPermissionMapper;
import com.emed.shopping.dao.mapper.admin.user.ShopRoleMapper;
import com.emed.shopping.dao.mapper.admin.user.ShopRolePermissionMapper;
import com.emed.shopping.dao.mapper.admin.user.ShopUserRoleMapper;
import com.emed.shopping.dao.model.admin.user.*;
import com.emed.shopping.service.admin.user.UserService;
import com.emed.shopping.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 周润斌
 * @Date: create in 上午 12:43 2018/1/26 0026
 * @Description:
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<ShopUser> implements UserService {

    @Autowired
    private ShopRoleMapper shopRoleMapper;
    @Autowired
    private ShopUserRoleMapper shopUserRoleMapper;
    @Autowired
    private ShopRolePermissionMapper shopRolePermissionMapper;
    @Autowired
    private ShopPermissionMapper shopPermissionMapper;

    @Override
    public List<ShopRole> findUserRoleById(Long id) {
        List<ShopRole> roles = new ArrayList<>();
        ShopUserRole userRole = new ShopUserRole();
        userRole.setUserId(id);
        List<ShopUserRole> userRoles = shopUserRoleMapper.select(userRole);
        if(CommonUtil.collectionIsNotEmpty(userRoles)){
            List<Long> ids = new ArrayList<>();
            for(ShopUserRole role: userRoles){
                ids.add(role.getRoleId());
            }
            Example example = new Example(ShopRole.class);
            example.createCriteria().andIn("id",ids);
            roles = shopRoleMapper.selectByExample(example);
        }
        return roles;
    }

    @Override
    public List<ShopPermission> findUserPermissionById(Long id) {
        List<ShopPermission> permissions = new ArrayList<>();
        ShopUserRole userRole = new ShopUserRole();
        userRole.setUserId(id);
        List<ShopUserRole> userRoles = shopUserRoleMapper.select(userRole);
        if(CommonUtil.collectionIsNotEmpty(userRoles)) {
            List<Long> ids = new ArrayList<>();
            for (ShopUserRole role : userRoles) {
                ids.add(role.getRoleId());
            }
            Example example = new Example(ShopRolePermission.class);
            example.createCriteria().andIn("roleId",ids);
            List<ShopRolePermission> rolePermissions = shopRolePermissionMapper.selectByExample(example);
            if(CommonUtil.collectionIsNotEmpty(rolePermissions)){
                List<Long> permissionIds = new ArrayList<>();
                for(ShopRolePermission permission: rolePermissions){
                    permissionIds.add(permission.getPermissionId());
                }
                Example permissionExample = new Example(ShopPermission.class);
                permissionExample.createCriteria().andIn("id",permissionIds);
                permissions = shopPermissionMapper.selectByExample(permissionExample);
            }
        }
        return permissions;
    }
}
