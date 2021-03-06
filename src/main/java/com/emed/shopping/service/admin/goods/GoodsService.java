package com.emed.shopping.service.admin.goods;

import com.emed.shopping.base.BaseService;
import com.emed.shopping.dao.model.admin.goods.ShopGoods;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 14:46 2018/1/16 0016
 * @Description:
 */
public interface GoodsService extends BaseService<ShopGoods> {

    List<Map> selectGoodsList(Map map);

}
