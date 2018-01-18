package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.dao.model.admin.goods.ShopGoods;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsClass;
import com.emed.shopping.service.admin.goods.GoodsClassService;
import com.emed.shopping.service.admin.goods.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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

    @RequestMapping(value = "/index")
    public String index(){

        return "/admin/goods/goods/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        PageInfo<ShopGoods> pageInfo = goodsService.selectPage(offset, limit, new ShopGoods(), sort + " " + order);
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }

}