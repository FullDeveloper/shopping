package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrand;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrandCategory;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsClass;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsType;
import com.emed.shopping.dao.model.admin.system.ShopAccessory;
import com.emed.shopping.service.admin.goods.GoodsBrandCategoryService;
import com.emed.shopping.service.admin.goods.GoodsBrandService;
import com.emed.shopping.service.admin.goods.GoodsTypeService;
import com.emed.shopping.service.admin.system.AccessoryService;
import com.emed.shopping.service.admin.system.SysConfigService;
import com.emed.shopping.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 11:53 2018/1/16 0016
 * @Description: 商品品牌管理控制器
 */
@Controller
@RequestMapping(value = "/goods/brand")
@Transactional
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;
    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private AccessoryService accessoryService;
    @Autowired
    private GoodsBrandCategoryService goodsBrandCategoryService;

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
            @RequestParam(required = false, value = "order") String order,
            @RequestParam Map map) {
        Map<String, Object> result = new HashMap<>(2);
        map.put("orderStr",sort + " " + order);
        List<Map> results = goodsBrandService.selectBrandDataList(map);
        int count = goodsBrandService.selectBrandDataListCount(map);
        result.put("rows", results);
        result.put("total", count);
        return result;
    }

    @RequestMapping(value = "/addPage")
    public String addPage(){

        return "/admin/goods/brand/add";
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Object save(HttpServletRequest request,ShopGoodsBrand shopGoodsBrand){
        String uploadFilePath = sysConfigService.getSysConfig().getUploadFilePath();
        String saveFilePathName = request.getSession().getServletContext().getRealPath("/")+uploadFilePath+ File.separator + "brand";
        try {
            //设置品牌属性
            shopGoodsBrand.setAudit(1);
            shopGoodsBrand.setUserStatus(0);
            //设置品牌类型属性
            ShopGoodsBrandCategory category = new ShopGoodsBrandCategory();
            category.setName(request.getParameter("className"));
            ShopGoodsBrandCategory result = goodsBrandCategoryService.selectOne(category);
            if(result == null){
                ShopGoodsBrandCategory brandCategory = new ShopGoodsBrandCategory();
                brandCategory.setName(request.getParameter("className"));
                goodsBrandCategoryService.save(brandCategory);
                shopGoodsBrand.setCategoryId(brandCategory.getId());
            }else{
                shopGoodsBrand.setCategoryId(result.getId());
            }
            //处理是否上传logo图片
            Map map = CommonUtil.saveFileToServer(request, "accessoryImage",
                    saveFilePathName, "", null);
            //看之前是否存在图片
            ShopAccessory accessory = null;
            if(shopGoodsBrand.getId() != null){
                Long logoId = shopGoodsBrand.getAccessoryId();
                accessory = accessoryService.selectByPrimaryKey(logoId);
            }
            //判断是否上传图片
            if(!StringUtils.isEmpty(map.get("fileName"))){
                if(accessory == null){
                    accessory = new ShopAccessory();
                }
                accessory.setName(CommonUtil.nullToString(map.get("fileName")));
                accessory.setExt(CommonUtil.nullToString(map.get("mime")));
                accessory.setSize((int)CommonUtil.nullToFloat(map.get("fileSize")));
                accessory.setPath(uploadFilePath + "/brand");
                accessory.setWidth(CommonUtil.nullToInt(map.get("width")));
                accessory.setHeight(CommonUtil.nullToInt(map.get("height")));
                accessoryService.save(accessory);
                //设置关联的图片
                shopGoodsBrand.setAccessoryId(accessory.getId());
            }
            goodsBrandService.save(shopGoodsBrand);
            return BaseResult.ok("操作成功",null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BaseResult(300,"操作失败",null);
    }

    @RequestMapping(value = "/toUpdatePage")
    public String toUpdatePage(Long id,Model model){
        Map brand = goodsBrandService.selectBrandFullDataById(id);
        model.addAttribute("brand",brand);
        return "/admin/goods/brand/update";
    }

    @RequestMapping(value = "/changeRecommend",method = RequestMethod.POST)
    @ResponseBody
    public Object changeRecommend(ShopGoodsBrand goodsBrand){
        int i = goodsBrandService.updateByPrimaryKeySelective(goodsBrand);
        return BaseResult.ok("操作成功",i);
    }

    @RequestMapping(value = "/deleteBrand",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteBrand(Long id) {
        ShopGoodsBrand brand = goodsBrandService.selectByPrimaryKey(id);
        brand.setDeleteStatus("1");
        goodsBrandService.updateByPrimaryKey(brand);
        return BaseResult.ok("操作成功",null);
    }

}
