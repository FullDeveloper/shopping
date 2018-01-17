package com.emed.shopping.service.admin.system;

import com.emed.shopping.base.BaseService;
import com.emed.shopping.dao.model.admin.system.ShopSysConfig;

/**
 * @Author: 周润斌
 * @Date: create in 上午 10:11 2018/1/17 0017
 * @Description:
 */
public interface SysConfigService extends BaseService<ShopSysConfig> {

    ShopSysConfig getSysConfig();

}
