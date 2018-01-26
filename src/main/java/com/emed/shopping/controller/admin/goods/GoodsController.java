package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.model.admin.goods.ShopGoods;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrand;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsClass;
import com.emed.shopping.dao.model.admin.store.ShopStore;
import com.emed.shopping.service.admin.goods.GoodsBrandService;
import com.emed.shopping.service.admin.goods.GoodsClassService;
import com.emed.shopping.service.admin.goods.GoodsService;
import com.emed.shopping.service.admin.store.ShopStoreService;
import com.emed.shopping.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 14:47 2018/1/16 0016
 * @Description:
 */
@Controller
@RequestMapping(value = "/goods/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsBrandService goodsBrandService;
    @Autowired
    private GoodsClassService goodsClassService;
    @Autowired
    private ShopStoreService shopStoreService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        //1.拿到品牌信息
        List<ShopGoodsBrand> brandList = goodsBrandService.select(null);
        model.addAttribute("brandList",brandList);
        //2.拿到类别信息
        List<ShopGoodsClass> classList = goodsClassService.select(null);
        model.addAttribute("classList",classList);
        return "/admin/goods/goods/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order,
            @RequestParam Map map) {
        PageHelper.offsetPage(offset, limit);
        map.put("order",sort + " " + order);
        List<Map> objList = goodsService.selectGoodsList(map);
        PageInfo pageInfo = new PageInfo(objList);
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/changeRecommend",method = RequestMethod.POST)
    @ResponseBody
    public Object changeRecommend(ShopGoods goods){
        int i = goodsService.updateByPrimaryKeySelective(goods);
        return BaseResult.ok("操作成功",i);
    }

    @RequestMapping(value = "/goodsDetails")
    public String goodsDetails(Long id , Model model){
        String retUrl = "/web/";
        //1.查到这个商品
        ShopGoods goods = goodsService.selectByPrimaryKey(id);
        //2.拿到这个商品所在的店铺信息
        ShopStore store = shopStoreService.selectByPrimaryKey(goods.getGoodsStoreId());
        //判断状态是否为上架 0:上架
        if(goods.getGoodsStatus() == 0){
            //设置一个默认模板
            String template = "default";
            if(!CommonUtil.isEmpty(store.getTemplate())){
                template = store.getTemplate();
            }
            retUrl += template + "/store_goods";
            //设置点击次数+1
            goods.setGoodsClick(goods.getGoodsClick()+1);
            //设置团购
            goodsService.updateByPrimaryKey(goods);
            if(store.getStoreStatus() == 2){
                model.addAttribute("goods",goods);
                model.addAttribute("store",store);
                //查询出这个店铺中拥有的类型
            }
            return retUrl;
        }
        return "";
    }

}
