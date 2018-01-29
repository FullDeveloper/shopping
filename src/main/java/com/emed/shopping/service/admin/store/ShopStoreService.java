package com.emed.shopping.service.admin.store;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.base.BaseService;
import com.emed.shopping.dao.model.admin.store.ShopStore;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public interface ShopStoreService extends BaseService<ShopStore> {
    BaseResult updateStoreInfo(HttpServletRequest request);


    void insertAndGetId(ShopStore shopStore);
}
