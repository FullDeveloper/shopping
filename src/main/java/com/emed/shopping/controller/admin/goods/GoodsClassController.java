package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.base.TreeResult;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsClass;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsType;
import com.emed.shopping.service.admin.goods.GoodsClassService;
import com.emed.shopping.service.admin.goods.GoodsTypeService;
import net.sf.json.JSONArray;
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
 * @Date: create in 上午 13:49 2018/1/16 0016
 * @Description:
 */
@Controller
@RequestMapping(value = "/goods/class")
public class GoodsClassController {

    @Autowired
    private GoodsClassService goodsClassService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        List<TreeResult> treeResults = goodsClassService.getGoodsClassSubList();
        JSONArray arr = JSONArray.fromObject(treeResults);
        String json = arr.toString();
        json = json.replaceAll("parentId","pId");
        model.addAttribute("zTreeStr",json);
        return "/admin/goods/class/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order,
            Long parentId) {
        Map map = new HashMap<>();
        ShopGoodsClass goodsClass = new ShopGoodsClass();
        if(parentId != null){
            map.put("parentId",parentId);
            goodsClass.setParentId(parentId);
        }
        map.put("order",sort + " " + order);
        map.put("offset",offset);
        map.put("limit",limit);
        List<Map> classJoinList = goodsClassService.selectGoodsClassJoinList(map);
        int total = goodsClassService.selectCount(goodsClass);
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", classJoinList);
        result.put("total", total);
        return result;
    }
    @RequestMapping(value = "/editPage")
    public String addPage(Model model,String flag,Long id) {
        List<TreeResult> classList = goodsClassService.getGoodsClassSubList();
        List<ShopGoodsType> typeList = goodsTypeService.select(null);
        model.addAttribute("classList",classList);
        JSONArray array = JSONArray.fromObject(classList);
        JSONArray type = JSONArray.fromObject(typeList);
        String typeStr = type.toString();
        typeStr = typeStr.replaceAll("name","text");
        String json = array.toString();
        json = json.replaceAll("className","text");
        model.addAttribute("jsonStr",json);
        model.addAttribute("typeStr",typeStr);
        String retUrl = "/admin/goods/class/add";
        if(flag != null){
            retUrl = "/admin/goods/class/update";
            Map goodsClass  = goodsClassService.selectFllDataById(id);
            model.addAttribute("goods",goodsClass);
        }
        return retUrl;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Object save(ShopGoodsClass goodsClass){
        goodsClass.setLevel(goodsClass.getLevel()==null?0: goodsClass.getLevel()+1);
        goodsClassService.save(goodsClass);
        return new BaseResult(1,"操作成功",null);
    }

    @RequestMapping(value = "/changeStatus",method = RequestMethod.POST)
    @ResponseBody
    public Object changeRecommend(ShopGoodsClass goodsClass){
        int i = goodsClassService.updateByPrimaryKeySelective(goodsClass);
        return BaseResult.ok("操作成功",i);
    }

    @RequestMapping(value = "/deleteGoodsClass",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteGoodsClass(Long id){
        //1.找到该类型
        ShopGoodsClass goodsClass = goodsClassService.selectByPrimaryKey(id);
        //2.找到该类型下的子类并删除
        cascadeDelete(goodsClass.getId());
        //3.删除自己
        goodsClass.setDeleteStatus("1");
        goodsClassService.updateByPrimaryKey(goodsClass);
        return BaseResult.ok("操作成功",null);
    }

    public void cascadeDelete(Long parentId){
        ShopGoodsClass query = new ShopGoodsClass();
        query.setParentId(parentId);
        List<ShopGoodsClass> subList = goodsClassService.select(query);
        if(subList != null){
            for(ShopGoodsClass shopGoodsClass: subList){
                cascadeDelete(shopGoodsClass.getId());
                shopGoodsClass.setDeleteStatus("1");
                goodsClassService.updateByPrimaryKey(shopGoodsClass);
            }
        }
    }

  /*  @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("createTime");
        webDataBinder.setDisallowedFields("sort");
    }*/

}
