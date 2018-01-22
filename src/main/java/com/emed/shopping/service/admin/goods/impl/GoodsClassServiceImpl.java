package com.emed.shopping.service.admin.goods.impl;

import com.emed.shopping.base.BaseServiceImpl;
import com.emed.shopping.base.TreeResult;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsClassMapper;
import com.emed.shopping.dao.model.admin.goods.ShopGoods;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsClass;
import com.emed.shopping.service.admin.goods.GoodsClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 13:48 2018/1/16 0016
 * @Description:
 */
@Service
public class GoodsClassServiceImpl extends BaseServiceImpl<ShopGoodsClass> implements GoodsClassService {

    @Autowired
    private ShopGoodsClassMapper goodsClassMapper;

    @Override
    public List<ShopGoodsClass> getGoodsClassSubListByParentList(List<ShopGoodsClass> classes) {
        if(classes != null){
            for(ShopGoodsClass goodsClass: classes){
                ShopGoodsClass shopGoodsClass = new ShopGoodsClass();
                shopGoodsClass.setParentId(goodsClass.getId());
                List<ShopGoodsClass> classList = goodsClassMapper.select(shopGoodsClass);
                if(classList != null){
                    goodsClass.setNodes(classList);
                    getGoodsClassSubListByParentList(classList);
                }
            }
        }
        return classes;
    }

    @Override
    public List<TreeResult> getGoodsClassSubList(){
        //查询出所有的类型
        List<TreeResult> classList = goodsClassMapper.selectGoodsClassList();
        //遍历所有的类型 为0的弄成一个集合
        List<TreeResult> parentList = new ArrayList<>();
        for(int i=0;i<classList.size();i++){
            TreeResult goodsClass = classList.get(i);
            if(goodsClass.getParentId().equals(0L)){
                parentList.add(goodsClass);
                classList.remove(i);
                i--;
            }
        }
        return eachGoodsClassList(parentList,classList);
    }

    @Override
    public List<Map> selectGoodsClassJoinList(Map map) {
        return goodsClassMapper.selectGoodsClassJoinList(map);
    }

    @Override
    public Map selectFllDataById(Long id) {
        return goodsClassMapper.selectFllDataById(id);
    }

    public List<TreeResult> eachGoodsClassList(List<TreeResult> parentList,List<TreeResult> classList){
        //遍历父菜单下面所有的子菜单
        for(int i=0;i<parentList.size();i++){
            for(int j=0;j<classList.size();j++){
                //如果这个节点的父节点是当前节点的Id
                if(parentList.get(i).getId().equals(classList.get(j).getParentId())){
                    List<TreeResult> nodes = parentList.get(i).getNodes();
                    //则加入到他的子节点集合中
                    nodes.add(classList.get(j));
                    parentList.get(i).setNodes(nodes);
                    //删除当前这个节点
                    classList.remove(j);
                    j--;
                    //遍历子节点 查看是否子节点下还有子节点
                    eachGoodsClassList(nodes,classList);
                }
            }
        }
        return parentList;
    }

}
