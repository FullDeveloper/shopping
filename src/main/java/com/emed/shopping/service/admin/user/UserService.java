package com.emed.shopping.service.admin.user;

import com.emed.shopping.base.BaseService;
import com.emed.shopping.dao.model.admin.user.ShopPermission;
import com.emed.shopping.dao.model.admin.user.ShopRole;
import com.emed.shopping.dao.model.admin.user.ShopUser;

import java.util.List;

/**
 * @Author: 周润斌
 * @Date: create in 上午 12:41 2018/1/26 0026
 * @Description:
 */
public interface UserService extends BaseService<ShopUser> {

    List<ShopRole> findUserRoleById(Long id);

    List<ShopPermission> findUserPermissionById(Long id);
}
