package com.emed.shopping.dao.mapper.admin.goods;

import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrandCategory;
import com.emed.shopping.util.CommonMapper;

import java.util.List;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:19 2018/1/23 0023
 * @Description:
 */
public interface ShopGoodsBrandCategoryMapper extends CommonMapper<ShopGoodsBrandCategory> {

    List<ShopGoodsBrandCategory> selectBrandCategoryList();
}
