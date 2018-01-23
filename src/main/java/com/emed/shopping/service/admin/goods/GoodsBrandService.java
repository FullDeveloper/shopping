package com.emed.shopping.service.admin.goods;

import com.emed.shopping.base.BaseService;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrand;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 11:51 2018/1/16 0016
 * @Description:
 */
public interface GoodsBrandService extends BaseService<ShopGoodsBrand> {

    List<Map> selectBrandDataList(Map map);

    Map selectBrandFullDataById(Long id);

    int selectBrandDataListCount(Map map);


}
