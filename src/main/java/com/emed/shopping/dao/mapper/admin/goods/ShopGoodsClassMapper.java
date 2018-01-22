package com.emed.shopping.dao.mapper.admin.goods;

import com.emed.shopping.base.TreeResult;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsClass;
import com.emed.shopping.util.CommonMapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:46 2018/1/16 0016
 * @Description:
 */
public interface ShopGoodsClassMapper extends CommonMapper<ShopGoodsClass> {

    List<TreeResult> selectGoodsClassList();

    List<Map> selectGoodsClassJoinList(Map map);

    Map selectFllDataById(Long id);
}
