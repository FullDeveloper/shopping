package com.emed.shopping.controller.admin.store;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.mapper.admin.store.ShopStoreClassMapper;
import com.emed.shopping.dao.mapper.admin.store.ShopStoreMapper;
import com.emed.shopping.dao.model.admin.store.ShopArea;
import com.emed.shopping.dao.model.admin.store.ShopStore;
import com.emed.shopping.dao.model.admin.store.ShopStoreClass;
import com.emed.shopping.service.admin.store.ShopAreaService;
import com.emed.shopping.service.admin.store.ShopStoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    @Autowired
    private ShopAreaService shopAreaService;
    @Autowired
    private ShopStoreClassMapper shopStoreClassMapper;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/admin/store/manager/index";
    }

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

        for (int i = 0; i < pageInfo.getList().size(); i++) {
            Object validity = pageInfo.getList().get(i).get("validity");
            if(validity!=null){
                String s = com.emed.shopping.util.DateUtils.formatDateByFormat((Date) validity, "yyyy-MM-dd");
                pageInfo.getList().get(i).put("validity",s);
            }else{
                pageInfo.getList().get(i).put("validity","");
            }
        }
       result.put("rows", pageInfo.getList());
       result.put("total", pageInfo.getTotal());
       return result;
   }

    @RequestMapping(value = "/changeRecommend")
    public void changeRecommend(String id,boolean flag){
        ShopStore shopStore1 = shopStoreMapper.selectByPrimaryKey(Long.parseLong(id));
        if(flag){
            shopStore1.setStoreRecommend("1");   //1位推荐2位不推荐
        }else {
            shopStore1.setStoreRecommend("2");
        }
        shopStoreMapper.updateByPrimaryKeySelective(shopStore1);
    }

    @RequestMapping(value = "/deleteStoreById")
    public void deleteStoreById(String id){
       shopStoreService.deleteByPrimaryKey(Long.parseLong(id));
    }

    //跳转到更新店铺页面
    @RequestMapping(value = "/toEditStore")
    public ModelAndView toEditStore(String id){
        List<Map> oneStoreById = shopStoreMapper.getOneStoreById(Long.parseLong(id));
        List<ShopStoreClass> shopStoreClasses = shopStoreClassMapper.selectAll();

        ModelAndView modelAndView = new ModelAndView("/admin/store/manager/update");
        modelAndView.addObject("shopStoreClasses",shopStoreClasses);
        modelAndView.addObject("map",oneStoreById.get(0));
        return modelAndView;
    }

    @RequestMapping(value = "/getAddress")
    @ResponseBody
    public List<ShopArea> getAddress(String item,String id){
        if("province".equals(item))
            return shopAreaService.findFullArea().get("provinceInfo");
        else
            return shopAreaService.getAddressByLevel(id);
    }

    @RequestMapping(value="/updateStoreInfo")
    @ResponseBody
    public Object updateStoreInfo(HttpServletRequest request, HttpServletResponse response){
        BaseResult baseResult = shopStoreService.updateStoreInfo(request);
        return baseResult;
    }

}
