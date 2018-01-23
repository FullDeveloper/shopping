package com.emed.shopping.service.admin.goods.impl;

import com.emed.shopping.base.BaseServiceImpl;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsBrandMapper;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrand;
import com.emed.shopping.service.admin.goods.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 11:52 2018/1/16 0016
 * @Description:
 */
@Service
public class GoodsBrandServiceImpl extends BaseServiceImpl<ShopGoodsBrand> implements GoodsBrandService {

    @Autowired
    private ShopGoodsBrandMapper goodsBrandMapper;

    @Override
    public List<Map> selectBrandDataList(Map map) {
        return goodsBrandMapper.selectBrandDataList(map);
    }

    @Override
    public Map selectBrandFullDataById(Long id) {
        return goodsBrandMapper.selectBrandFullDataById(id);
    }

    @Override
    public int selectBrandDataListCount(Map map) {
        return goodsBrandMapper.selectBrandDataListCount(map);
    }
}
