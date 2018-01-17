package com.emed.shopping.controller.admin.store;

import com.emed.shopping.dao.mapper.admin.store.ShopStoreMapper;
import com.emed.shopping.dao.model.admin.store.ShopStore;
import com.emed.shopping.service.admin.store.ShopStoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YeFei on  2018/1/16 0016  下午 3:11 .
 * Description:店铺管理控制层
 */
@Controller
@RequestMapping("/store/manager")
public class StoreManagerController {
    @Autowired
    private ShopStoreService shopStoreService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/admin/store/manager/index";
    }

   /* @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        PageInfo<ShopGoodsSpecification> pageInfo = goodsSpecificationService.selectPage(offset, limit, new ShopGoodsSpecification(), sort + " " + order);
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }*/

   @Autowired
   private ShopStoreMapper shopStoreMapper;


    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(
           @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
           @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
           @RequestParam(required = false, value = "add_time") String sort,
           @RequestParam(required = false, value = "order") String order) {
       Map<String, Object> result = new HashMap<>(2);
      /* PageInfo<ShopStore> pageInfo = shopStoreService.selectPage(offset, limit, new ShopStore(), sort + " " + order);
       List<ShopStore> list = pageInfo.getList();*/
        PageHelper.startPage(offset, limit);
        List<Map> allStoreList = shopStoreMapper.getAllStoreList();
        PageInfo<Map> pageInfo=new PageInfo<>(allStoreList);

       result.put("rows", pageInfo.getList());
       result.put("total", pageInfo.getTotal());
       return result;
   }

}
