package com.emed.shopping.service.admin.goods.impl;

import com.emed.shopping.base.BaseServiceImpl;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsMapper;
import com.emed.shopping.dao.model.admin.goods.ShopGoods;
import com.emed.shopping.service.admin.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 14:46 2018/1/16 0016
 * @Description:
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<ShopGoods> implements GoodsService {

    @Autowired
    private ShopGoodsMapper goodsMapper;

    @Override
    public List<Map> selectGoodsList(Map map) {
        return goodsMapper.selectGoodsList(map);
    }
}
