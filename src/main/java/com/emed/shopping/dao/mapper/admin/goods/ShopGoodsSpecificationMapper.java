package com.emed.shopping.dao.mapper.admin.goods;

import com.emed.shopping.dao.model.admin.goods.ShopGoodsSpecification;
import com.emed.shopping.util.CommonMapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 10:54 2018/1/16 0016
 * @Description:
 */
public interface ShopGoodsSpecificationMapper extends CommonMapper<ShopGoodsSpecification> {

    List<ShopGoodsSpecification> selectSpecificationAndPropertyList(Map map);

}
