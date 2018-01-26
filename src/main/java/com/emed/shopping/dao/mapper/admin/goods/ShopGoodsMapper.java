package com.emed.shopping.dao.mapper.admin.goods;

import com.emed.shopping.dao.model.admin.goods.ShopGoods;
import com.emed.shopping.util.CommonMapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 14:45 2018/1/16 0016
 * @Description:
 */
public interface ShopGoodsMapper extends CommonMapper<ShopGoods> {

    List<Map> selectGoodsList(Map map);

}
