package com.emed.shopping.service.admin.store;

import com.emed.shopping.base.BaseService;
import com.emed.shopping.dao.model.admin.store.ShopArea;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/18 0018.
 */
public interface ShopAreaService extends BaseService<ShopArea> {
    Map<String,List<ShopArea>> findFullArea();

    List<ShopArea> getAddressByLevel(String id);
}
