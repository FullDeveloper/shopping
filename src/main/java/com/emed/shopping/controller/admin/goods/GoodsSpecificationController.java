package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.dao.model.admin.goods.ShopGoodsSpecProperty;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsSpecification;
import com.emed.shopping.service.admin.goods.GoodsSpecPropertyService;
import com.emed.shopping.service.admin.goods.GoodsSpecificationService;
import com.emed.shopping.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 10:55 2018/1/16 0016
 * @Description: 商品规格控制器
 */
@Controller
@RequestMapping(value = "/goods/specification")
@Transactional
public class GoodsSpecificationController {

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;
    @Autowired
    private GoodsSpecPropertyService goodsSpecPropertyService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){

        return "/admin/goods/specification/index";
    }

    @RequestMapping(value = "/list")
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
    }

    @RequestMapping(value = "/addPage")
    public String addPage(){

        return "/admin/goods/specification/add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(HttpServletRequest request,ShopGoodsSpecification specification,Integer count){
        specification.setCreateTime(new Date());
        specification.setDeleteStatus("0");
        goodsSpecificationService.insert(specification);
        //处理规格属性

        return  null;
    }

    private void genericProperty(HttpServletRequest request,Long id,Integer count){
        for(int i=0;count != null && i<count;i++){
            Integer sequence = Integer.parseInt(request.getParameter("sequence_"+i));
            String value = CommonUtil.nullToString(request.getParameter("value_"+i));
            if(StringUtils.isEmpty(sequence) || StringUtils.isEmpty(value)){
                continue;
            }
            Long propertyId = Long.parseLong(request.getParameter("id_"+i));
            ShopGoodsSpecProperty property = null;
            if(!StringUtils.isEmpty(propertyId)){
                property = goodsSpecPropertyService.selectByPrimaryKey(propertyId);
            }else{
                property = new ShopGoodsSpecProperty();
            }
            property.setCreateTime(new Date());
            property.setSort(sequence);
            property.setValue(value);
            String uploadFilePath = "";




        }


    }


}
