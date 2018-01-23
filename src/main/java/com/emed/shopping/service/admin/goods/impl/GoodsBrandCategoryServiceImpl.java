package com.emed.shopping.service.admin.goods.impl;

import com.emed.shopping.base.BaseServiceImpl;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsBrandCategoryMapper;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrandCategory;
import com.emed.shopping.service.admin.goods.GoodsBrandCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:20 2018/1/23 0023
 * @Description:
 */
@Service
public class GoodsBrandCategoryServiceImpl extends BaseServiceImpl<ShopGoodsBrandCategory> implements GoodsBrandCategoryService {

    @Autowired
    private ShopGoodsBrandCategoryMapper shopGoodsBrandCategoryMapper;

    @Override
    public List<ShopGoodsBrandCategory> selectBrandCategoryList() {
        return shopGoodsBrandCategoryMapper.selectBrandCategoryList();
    }
}
