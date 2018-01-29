package com.emed.shopping.controller.admin.store;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.mapper.admin.store.ShopStoreGradeMapper;
import com.emed.shopping.dao.model.admin.store.ShopStoreGrade;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

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
        Example example = new Example(ShopStoreGrade.class);
        if (!StringUtils.isEmpty(map.get("keywords")))
            example.createCriteria().andLike("gradeName","%"+map.get("keywords")+"%");
        List<ShopStoreGrade> shopStoreGrades = shopStoreGradeMapper.selectByExample(example);
        PageInfo<ShopStoreGrade> pageInfo = new PageInfo<>(shopStoreGrades);
        result.put("rows", shopStoreGrades);
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/toAddPage")
    public String toAddPage(){
        return "/admin/store/type/addPage";
    }

    /**
     * 新增类型
     * @param shopStoreGrade
     * @param request
     * @return
     */
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
     * 编辑类型且保存
     * @param shopStoreGrade
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateTypeInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object updateTypeInfo(ShopStoreGrade shopStoreGrade, HttpServletRequest request){
        shopStoreGrade.setAudit(request.getParameter("audit1").equals("on")?true:false);
        int insert = shopStoreGradeMapper.updateByPrimaryKeySelective(shopStoreGrade);
        if(insert!=0)
            return new BaseResult(200,"修改类型成功!",shopStoreGrade);
        else
            return new BaseResult(400,"修改类型失败,请联系管理员!",shopStoreGrade);
    }

    /**
     * 删除记录
     */
    @RequestMapping(value="/deleteTypeById")
    public Object deleteTypeById(String id){
        String[] ids;
        if(id.contains(",")){
            ids = id.split(",");
        }else{
            ids = new String[]{id};
        }
        int j = 0;
        int[] result = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            j = shopStoreGradeMapper.deleteByPrimaryKey(Long.parseLong(ids[i]));
            result[i] = j;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i]!=0)
                continue;
            else
                return new BaseResult(400,"删除该条类型失败,请联系管理员处理!",null);
        }
        return new BaseResult(200,"成功删除该条类型!",null);
    }

    /**
     * 跳转到更新页面,带数据回显
     * @param id
     * @return
     */
    @RequestMapping(value="/toEditType")
    public String toEditType(String id,Model model){
        ShopStoreGrade shopStoreGrade = shopStoreGradeMapper.selectByPrimaryKey(Long.parseLong(id));
        model.addAttribute("shopStoreGrade",shopStoreGrade);
        return "/admin/store/type/update";
    }


}
