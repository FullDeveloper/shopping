package com.emed.shopping.dao.mapper.admin.store;

import com.emed.shopping.dao.model.admin.store.ShopStore;
import com.emed.shopping.util.CommonMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public interface ShopStoreMapper extends CommonMapper<ShopStore> {
    List<Map> getAllStoreList(Map map);
    List<Map> getOneStoreById(Long id);

    void insertAndGetId(ShopStore shopStore);
}
