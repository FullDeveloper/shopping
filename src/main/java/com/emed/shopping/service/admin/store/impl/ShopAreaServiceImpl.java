package com.emed.shopping.service.admin.store.impl;

import com.emed.shopping.base.BaseServiceImpl;
import com.emed.shopping.dao.mapper.admin.store.ShopAreaMapper;
import com.emed.shopping.dao.model.admin.store.ShopArea;
import com.emed.shopping.service.admin.store.ShopAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/18 0018.
 */
@Service
public class ShopAreaServiceImpl extends BaseServiceImpl<ShopArea> implements ShopAreaService {

    @Autowired
    private ShopAreaMapper shopAreaMapper;
    @Override
    public Map<String,List<ShopArea>> findFullArea() {
        Example example = new Example(ShopArea.class);
        example.createCriteria().andEqualTo("level",0);
        List<ShopArea> provinceInfo = shopAreaMapper.selectByExample(example);

        example.createCriteria().andEqualTo("level",1);
        List<ShopArea> cityInfo = shopAreaMapper.selectByExample(example);

        example.createCriteria().andEqualTo("level",2);
        List<ShopArea> countyInfo = shopAreaMapper.selectByExample(example);

        Map<String,List<ShopArea>> map = new HashMap();
        map.put("provinceInfo",provinceInfo);
        map.put("cityInfo",cityInfo);
        map.put("countyInfo",countyInfo);
        return map;
    }

    @Override
    public List<ShopArea> getAddressByLevel(String id) {

            Example example = new Example(ShopArea.class);
            example.createCriteria().andEqualTo("parentId",Long.parseLong(id));
            List<ShopArea> shopAreas = shopAreaMapper.selectByExample(example);
            return shopAreas;

    }
}
