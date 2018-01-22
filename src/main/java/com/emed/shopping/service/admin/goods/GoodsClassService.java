package com.emed.shopping.service.admin.goods;

import com.emed.shopping.base.BaseService;
import com.emed.shopping.base.TreeResult;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsClass;

import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:48 2018/1/16 0016
 * @Description:
 */
public interface GoodsClassService extends BaseService<ShopGoodsClass> {

    /**
     * 获取父节点下所有的子节点
     * @param classes 父节点集合
     * @return
     */
    List<ShopGoodsClass> getGoodsClassSubListByParentList(List<ShopGoodsClass> classes);

    List<TreeResult> getGoodsClassSubList();

    List<Map> selectGoodsClassJoinList(Map map);

}
