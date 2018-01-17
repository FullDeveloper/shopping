package com.emed.shopping.dao.mapper.admin.store;

import com.emed.shopping.dao.model.admin.store.ShopStoreClass;
import com.emed.shopping.util.CommonMapper;

public interface ShopStoreClassMapper extends CommonMapper<ShopStoreClass> {
    int deleteByPrimaryKey(Long id);

    int insert(ShopStoreClass record);

    int insertSelective(ShopStoreClass record);

    ShopStoreClass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopStoreClass record);

    int updateByPrimaryKey(ShopStoreClass record);
}