package com.emed.shopping.controller.admin.store;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.mapper.admin.store.ShopStoreClassMapper;
import com.emed.shopping.dao.mapper.admin.store.ShopStoreGradeMapper;
import com.emed.shopping.dao.mapper.admin.store.ShopStoreMapper;
import com.emed.shopping.dao.mapper.admin.user.ShopUserMapper;
import com.emed.shopping.dao.model.admin.store.ShopArea;
import com.emed.shopping.dao.model.admin.store.ShopStore;
import com.emed.shopping.dao.model.admin.store.ShopStoreClass;
import com.emed.shopping.dao.model.admin.store.ShopStoreGrade;
import com.emed.shopping.dao.model.admin.user.ShopUser;
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
import tk.mybatis.mapper.entity.Example;

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
    @Autowired
    private ShopStoreMapper shopStoreMapper;
    @Autowired
    private ShopStoreGradeMapper shopStoreGradeMapper;
    @Autowired
    private ShopUserMapper shopUserMapper;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/admin/store/manager/index";
    }

    //检查用户是否之前创建过店铺
    @RequestMapping(value = "/toCheckStore", method = RequestMethod.GET)
    @ResponseBody
    public Object toCheckStore(String userName){
        Example example = new Example(ShopUser.class);
        example.createCriteria().andEqualTo("userName",userName);
        List<ShopUser> shopUsers = shopUserMapper.selectByExample(example);
        if(shopUsers.size() ==0)
            return new BaseResult(301,"该用户名不存在",null);
        ShopStore shopStore = shopStoreMapper.selectByPrimaryKey(shopUsers.get(0).getStoreId());
        if(shopStore==null){
            return new BaseResult(200,"该用户没有创建店铺,可以创建!",null);
        }else{
            return new BaseResult(300,"该用户已经创建过店铺,不可以重复创建!",shopStore);
        }
    }



    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam Map map) {
        Map<String, Object> result = new HashMap<>(2);
        PageHelper.startPage(Integer.parseInt(map.get("offset").toString()),Integer.parseInt(map.get("limit").toString()));
        List<Map> allStoreList = shopStoreMapper.getAllStoreList(map);
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

    //跳转到新增店铺页面
    @RequestMapping(value = "/toAddPage")
    public ModelAndView toAddPage(){

        List<ShopStoreClass> shopStoreClasses = shopStoreClassMapper.selectAll();
        List<ShopStoreGrade> shopStoreGrades = shopStoreGradeMapper.selectAll();
        ModelAndView modelAndView = new ModelAndView("/admin/store/manager/addPage");
        modelAndView.addObject("shopStoreGrades",shopStoreGrades);
        modelAndView.addObject("shopStoreClasses",shopStoreClasses);
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

    //更新店铺信息
    @RequestMapping(value="/updateStoreInfo")
    @ResponseBody
    public Object updateStoreInfo(HttpServletRequest request, HttpServletResponse response){
        BaseResult baseResult = shopStoreService.updateStoreInfo(request);
        return baseResult;
    }

    //新增店铺信息  类型,用户名
    @RequestMapping(value="/saveStoreInfo",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updateStoreInfo(HttpServletRequest request){
        ShopStore shopStore = new ShopStore();
        shopStore.setStoreName(request.getParameter("storeName"));
        shopStore.setStoreOwer(request.getParameter("storeOwer"));
        shopStore.setAreaId(Long.parseLong(request.getParameter("Village")));
        shopStore.setStoreAddress(request.getParameter("storeAddress"));
        shopStore.setStoreZip(request.getParameter("storeZip"));
        shopStore.setStoreCredit(0);
        shopStore.setAddTime(new Date());
        shopStore.setStoreOwerCard(request.getParameter("storeOwerCard"));
        shopStore.setScId(Long.parseLong(request.getParameter("className")));
        shopStore.setStoreTelephone(request.getParameter("storeTelephone"));
        shopStore.setGradeId(Long.parseLong(request.getParameter("gradeName")));
        shopStore.setStoreStatus(Integer.parseInt(request.getParameter("storeStatus")));
        shopStore.setStoreRecommend(request.getParameter("recommend")=="on"?"1":"2");
        String storeApprove = request.getParameter("cardApprove");
        if(storeApprove!=null && storeApprove.equals("实名认证"))
            shopStore.setCardApprove("1");
        else
            shopStore.setCardApprove("0");
        String realstoreApprove = request.getParameter("realstoreApprove");
        if(realstoreApprove!=null && realstoreApprove.equals("实体店铺认证"))
            shopStore.setRealstoreApprove("1");
        else
            shopStore.setRealstoreApprove("0");
        shopStoreService.insertAndGetId(shopStore);
        Example example = new Example(ShopUser.class);
        example.createCriteria().andEqualTo("userName",request.getParameter("userName"));
        List<ShopUser> shopUsers = shopUserMapper.selectByExample(example);
        shopUsers.get(0).setStoreId(shopStore.getId());
        int i = shopUserMapper.updateByPrimaryKeySelective(shopUsers.get(0));
        if(i!=0){
            return new BaseResult(200,"新增店铺成功!",shopStore);
        }else{
            return new BaseResult(400,"新增店铺失败!",shopStore);
        }
    }
}
