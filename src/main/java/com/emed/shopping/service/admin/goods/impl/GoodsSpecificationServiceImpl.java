package com.emed.shopping.service.admin.goods.impl;

import com.emed.shopping.base.BaseServiceImpl;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsSpecificationMapper;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsSpecification;
import com.emed.shopping.service.admin.goods.GoodsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 10:59 2018/1/16 0016
 * @Description:
 */
@Service
public class GoodsSpecificationServiceImpl extends BaseServiceImpl<ShopGoodsSpecification> implements GoodsSpecificationService {

    @Autowired
    private ShopGoodsSpecificationMapper specificationMapper;

    @Override
    public List<ShopGoodsSpecification> selectSpecificationAndPropertyList(Map map) {
        return specificationMapper.selectSpecificationAndPropertyList(map);
    }
}
