package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.dao.model.admin.ShopGoodsBrand;
import com.emed.shopping.dao.model.admin.ShopGoodsSpecification;
import com.emed.shopping.service.admin.goods.GoodsBrandService;
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
 * @Date: create in 上午 11:53 2018/1/16 0016
 * @Description:
 */
@Controller
@RequestMapping(value = "/goods/brand")
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;

    @RequestMapping(value = "/index")
    public String index(){

        return "/admin/goods/brand/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        PageInfo<ShopGoodsBrand> pageInfo = goodsBrandService.selectPage(offset, limit, new ShopGoodsBrand(), sort + " " + order);
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }


}
