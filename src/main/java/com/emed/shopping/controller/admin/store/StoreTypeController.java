package com.emed.shopping.controller.admin.store;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.mapper.admin.store.ShopStoreGradeMapper;
import com.emed.shopping.dao.model.admin.store.ShopStoreGrade;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 叶飞
 * @Date: create in  2018/1/25 0025 下午 5:01
 * @Project: shopping
 * @Description:
 */
@Controller
@RequestMapping("/store/type")
public class StoreTypeController {


    @Autowired
    private ShopStoreGradeMapper shopStoreGradeMapper;


    @RequestMapping(value = "/index")
    public String toTypePage(){
        return "/admin/store/type/index";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam Map map){
        Map<String,Object> result = new HashMap<>();
        PageHelper.startPage(Integer.parseInt(map.get("offset").toString()),Integer.parseInt(map.get("limit").toString()));
        List<ShopStoreGrade> shopStoreGrades = shopStoreGradeMapper.selectAll();
        PageInfo<ShopStoreGrade> pageInfo = new PageInfo<>(shopStoreGrades);
        result.put("rows", shopStoreGrades);
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/toAddPage")
    public String toAddPage(){
        return "/admin/store/type/addPage";
    }

    @RequestMapping(value = "/saveTypeInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object saveTypeInfo(ShopStoreGrade shopStoreGrade, HttpServletRequest request){
        shopStoreGrade.setAudit(request.getParameter("audit").equals("on")?true:false);
        shopStoreGrade.setAddFunciton("editor_multimedia");
        shopStoreGrade.setTemplates("0");
        shopStoreGrade.setAddTime(new Date());
        int insert = shopStoreGradeMapper.insert(shopStoreGrade);
        if(insert!=0)
            return new BaseResult(200,"新增品牌成功!",shopStoreGrade);
        else
            return new BaseResult(400,"新增商铺等级失败,请联系管理员!",shopStoreGrade);
    }

    /**
     * 删除记录
     */
    @RequestMapping(value="/deleteTypeById")
    public Object deleteTypeById(String id){
        long ids = Long.parseLong(id);
        int i = shopStoreGradeMapper.deleteByPrimaryKey(ids);
        if (i!=0)
            return new BaseResult(200,"成功删除该条类型!",null);
        else
            return new BaseResult(400,"删除该条类型失败,请联系管理员处理!",null);
    }
}
