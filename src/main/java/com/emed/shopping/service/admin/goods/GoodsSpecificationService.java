package com.emed.shopping.service.admin.goods;

import com.emed.shopping.base.BaseService;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsSpecification;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 10:58 2018/1/16 0016
 * @Description:
 */
public interface GoodsSpecificationService extends BaseService<ShopGoodsSpecification> {

    List<ShopGoodsSpecification> selectSpecificationAndPropertyList(Map map);

}
