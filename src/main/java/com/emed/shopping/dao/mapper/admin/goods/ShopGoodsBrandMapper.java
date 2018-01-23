package com.emed.shopping.dao.mapper.admin.goods;

import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrand;
import com.emed.shopping.util.CommonMapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 11:39 2018/1/16 0016
 * @Description:
 */
public interface ShopGoodsBrandMapper extends CommonMapper<ShopGoodsBrand> {

    List<Map> selectBrandDataList(Map map);

    Map selectBrandFullDataById(Long id);

    int selectBrandDataListCount(Map map);
}
