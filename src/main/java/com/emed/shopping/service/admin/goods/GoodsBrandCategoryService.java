package com.emed.shopping.service.admin.goods;

import com.emed.shopping.base.BaseService;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrandCategory;

import java.util.List;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:20 2018/1/23 0023
 * @Description:
 */
public interface GoodsBrandCategoryService extends BaseService<ShopGoodsBrandCategory> {

    List<ShopGoodsBrandCategory> selectBrandCategoryList();

}
