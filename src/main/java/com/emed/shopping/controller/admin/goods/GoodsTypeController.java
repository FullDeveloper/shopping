package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsTypeSpecMapper;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrandCategory;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsSpecification;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsType;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsTypeSpec;
import com.emed.shopping.service.admin.goods.GoodsBrandCategoryService;
import com.emed.shopping.service.admin.goods.GoodsSpecificationService;
import com.emed.shopping.service.admin.goods.GoodsTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private GoodsSpecificationService goodsSpecificationService;
    @Autowired
    private GoodsBrandCategoryService goodsBrandCategoryService;
    @Autowired
    private ShopGoodsTypeSpecMapper goodsTypeSpecMapper;

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
        //1.选择关联规格
        Map map = new HashMap();
        map.put("order","sort desc");
        List<ShopGoodsSpecification> goodsSpecifications = goodsSpecificationService.selectSpecificationAndPropertyList(map);
        //2.选择关联品牌
        List<ShopGoodsBrandCategory> categoryList = goodsBrandCategoryService.selectBrandCategoryList();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("goodsSpecifications",goodsSpecifications);
        return "/admin/goods/type/add";
    }


    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    @ResponseBody
    public Object save(HttpServletRequest request,ShopGoodsType shopGoodsType){
        //1.保存商品类型信息
        goodsTypeService.save(shopGoodsType);
        //2.建立商品类型和商品规格的关系
        Map map = request.getParameterMap();
        String[] propertyIds = (String[]) map.get("propertyIds");
        if(propertyIds != null){
            List<ShopGoodsTypeSpec> specArrayList = new ArrayList<>();
            for(String id: propertyIds){
                ShopGoodsTypeSpec typeSpec = new ShopGoodsTypeSpec();
                typeSpec.setSpecId(Long.parseLong(id));
                typeSpec.setTypeId(shopGoodsType.getId());
                specArrayList.add(typeSpec);
            }
            if(specArrayList.size()>0){
                goodsTypeSpecMapper.insertList(specArrayList);
            }
        }
        //3.建立商品类型和商品品牌的关联
        String[] brandId = (String[]) map.get("brandId");
        if(brandId != null){

        }
        return null;
    }



}
