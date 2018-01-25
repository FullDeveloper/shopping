package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsBrandMapper;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsTypeBrandMapper;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsTypePropertyMapper;
import com.emed.shopping.dao.mapper.admin.goods.ShopGoodsTypeSpecMapper;
import com.emed.shopping.dao.model.admin.goods.*;
import com.emed.shopping.service.admin.goods.GoodsBrandCategoryService;
import com.emed.shopping.service.admin.goods.GoodsBrandService;
import com.emed.shopping.service.admin.goods.GoodsSpecificationService;
import com.emed.shopping.service.admin.goods.GoodsTypeService;
import com.emed.shopping.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

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
@Transactional
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsSpecificationService goodsSpecificationService;
    @Autowired
    private GoodsBrandCategoryService goodsBrandCategoryService;
    @Autowired
    private ShopGoodsTypeSpecMapper goodsTypeSpecMapper;
    @Autowired
    private ShopGoodsTypePropertyMapper goodsTypePropertyMapper;
    @Autowired
    private ShopGoodsTypeBrandMapper goodsTypeBrandMapper;

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
        PageInfo<ShopGoodsType> pageInfo = goodsTypeService
                .selectPage(offset, limit, new ShopGoodsType(), sort + " " + order);
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/addPage")
    public String addPage(Model model) {
        //1.选择关联规格
        Map map = new HashMap();
        map.put("order", "sort desc");
        List<ShopGoodsSpecification> goodsSpecifications = goodsSpecificationService
                .selectSpecificationAndPropertyList(map);
        //2.选择关联品牌
        List<ShopGoodsBrandCategory> categoryList = goodsBrandCategoryService
                .selectBrandCategoryList();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("goodsSpecifications", goodsSpecifications);
        return "/admin/goods/type/add";
    }

    @RequestMapping(value = "/updatePage")
    public String updatePage(Long id, Model model) {
        //回显类型对象
        ShopGoodsType goodsType = goodsTypeService.selectByPrimaryKey(id);
        //回显关联规格对象
        List<ShopGoodsSpecification> specifications = echoGoodsSpec(goodsType.getId());
        //回显关联品牌对象
        List<ShopGoodsBrandCategory> brandCategories = echoGoodsTypeBrand(goodsType.getId());
        //回显关联的类型属性
        List<ShopGoodsTypeProperty> goodsTypeProperties = echoGoodsTypeProperties(goodsType.getId());
        //存到请求域对象中
        model.addAttribute("goodsType", goodsType);
        model.addAttribute("goodsSpecifications", specifications);
        model.addAttribute("brandCategories", brandCategories);
        model.addAttribute("goodsTypeProperties", goodsTypeProperties);
        return "/admin/goods/type/update";
    }

    @RequestMapping(value = "/deleteGoodsType" ,method = RequestMethod.POST)
    @ResponseBody
    public Object deleteGoodsType(Long id){
        goodsTypeService.deleteByPrimaryKey(id);
        cascadeDeleteType(id);
        return BaseResult.ok("操作成功",null);
    }

    private void cascadeDeleteType(Long typeId){
        //1.删除之前商品类型和商品规格建立的关系
        ShopGoodsTypeSpec spec = new ShopGoodsTypeSpec();
        spec.setTypeId(typeId);
        goodsTypeSpecMapper.delete(spec);
        //2.删除商品类型和商品品牌建立的关系
        ShopGoodsTypeBrand brand = new ShopGoodsTypeBrand();
        brand.setTypeId(typeId);
        goodsTypeBrandMapper.delete(brand);
        //3.删除商品类型下的属性
        ShopGoodsTypeProperty property = new ShopGoodsTypeProperty();
        property.setGoodsTypeId(typeId);
        goodsTypePropertyMapper.delete(property);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(HttpServletRequest request, ShopGoodsType shopGoodsType) {
        //1.如果是修改
        if(shopGoodsType.getId() != null){
            cascadeDeleteType(shopGoodsType.getId());
        }
        //1.保存商品类型信息
        goodsTypeService.save(shopGoodsType);
        //2.建立商品类型和商品规格的关系
        Map map = request.getParameterMap();
        String[] propertyIds = (String[]) map.get("propertyIds");
        if (propertyIds != null) {
            List<ShopGoodsTypeSpec> specArrayList = new ArrayList<>();
            for (String id : propertyIds) {
                ShopGoodsTypeSpec typeSpec = new ShopGoodsTypeSpec();
                typeSpec.setSpecId(Long.parseLong(id));
                typeSpec.setTypeId(shopGoodsType.getId());
                specArrayList.add(typeSpec);
            }
            if (specArrayList.size() > 0) {
                goodsTypeSpecMapper.insertList(specArrayList);
            }
        }
        //3.建立商品类型和商品品牌的关联
        String[] brandId = (String[]) map.get("brandId");
        if (brandId != null) {
            List<ShopGoodsTypeBrand> brandArrayList = new ArrayList<>();
            for (String id : brandId) {
                ShopGoodsTypeBrand typeBrand = new ShopGoodsTypeBrand();
                typeBrand.setBrandId(Long.parseLong(id));
                typeBrand.setTypeId(shopGoodsType.getId());
                brandArrayList.add(typeBrand);
            }
            if (brandArrayList.size() > 0) {
                goodsTypeBrandMapper.insertList(brandArrayList);
            }
        }
        //4.建立商品类型和商品属性的关联
        String[] idArray = (String[]) map.get("id_1");
        String[] sortArray = (String[]) map.get("sort_1");
        String[] nameArray = (String[]) map.get("name_1");
        String[] valueArray = (String[]) map.get("value_1");
        String[] displayArray = (String[]) map.get("displayIds");
        List<ShopGoodsTypeProperty> properties = new ArrayList<>();
        for (int i = 0; sortArray!=null && i < sortArray.length; i++) {
            ShopGoodsTypeProperty property = new ShopGoodsTypeProperty();
            property.setGoodsTypeId(shopGoodsType.getId());
            property.setDisplay(CommonUtil.nullToInt(displayArray[i]));
            property.setSort(CommonUtil.nullToInt(sortArray[i]));
            property.setName(nameArray[i]);
            property.setValue(valueArray[i]);
            properties.add(property);
        }
        if (properties.size() > 0) {
            goodsTypePropertyMapper.insertList(properties);
        }
        return BaseResult.ok("操作成功", null);
    }


    private List<ShopGoodsTypeProperty> echoGoodsTypeProperties(Long id){
        ShopGoodsTypeProperty property = new ShopGoodsTypeProperty();
        property.setGoodsTypeId(id);
        return goodsTypePropertyMapper.select(property);
    }

    private List<ShopGoodsBrandCategory> echoGoodsTypeBrand(Long id) {
        //拿到所有的品牌集合
        List<ShopGoodsBrandCategory> categoryList = goodsBrandCategoryService
                .selectBrandCategoryList();
        //拿到和类型关联的品牌集合
        ShopGoodsTypeBrand goodsTypeBrand = new ShopGoodsTypeBrand();
        goodsTypeBrand.setTypeId(id);
        List<ShopGoodsTypeBrand> brandList = goodsTypeBrandMapper.select(goodsTypeBrand);
        if (CommonUtil.collectionIsNotEmpty(brandList)) {
            for (ShopGoodsBrandCategory category : categoryList) {
                if (CommonUtil.collectionIsNotEmpty(category.getGoodsBrandList())) {
                    for (ShopGoodsTypeBrand typeBrand : brandList) {
                        for (ShopGoodsBrand brand : category.getGoodsBrandList()) {
                            if (typeBrand.getBrandId().equals(brand.getId())) {
                                brand.setChecked(true);
                            }
                        }
                    }
                }
            }
        }
        return categoryList;
    }


    private List<ShopGoodsSpecification> echoGoodsSpec(Long typeId) {
        //1.拿到所有的关联规格
        Map map = new HashMap();
        map.put("order", "sort desc");
        List<ShopGoodsSpecification> goodsSpecificationsAll = goodsSpecificationService
                .selectSpecificationAndPropertyList(map);
        //拿到商品类型关联的规格对象
        ShopGoodsTypeSpec typeBrand = new ShopGoodsTypeSpec();
        typeBrand.setTypeId(typeId);
        List<ShopGoodsTypeSpec> specList = goodsTypeSpecMapper.select(typeBrand);
        if (CommonUtil.collectionIsNotEmpty(specList)) {
            //遍历所有的规格和对联的对象  如果对应上将其设为被选中
            for (ShopGoodsTypeSpec specification : specList) {
                for (ShopGoodsSpecification all : goodsSpecificationsAll) {
                    if (specification.getSpecId().equals(all.getId())) {
                        all.setChecked(true);
                    }
                }
            }
        }
        return goodsSpecificationsAll;
    }

}
