package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.dao.model.admin.ShopGoodsType;
import com.emed.shopping.service.admin.goods.GoodsTypeService;
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
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 17:53 2018/1/15 0015
 * @Description:
 */

@RequestMapping(value = "/goods/type")
@Controller
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return "/admin/goods/type/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        PageInfo<ShopGoodsType> pageInfo = goodsTypeService.selectPage(offset, limit, new ShopGoodsType(), sort + " " + order);
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/addPage")
    public String addPage(Model model) {

        return "/admin/goods/type/add";
    }

}