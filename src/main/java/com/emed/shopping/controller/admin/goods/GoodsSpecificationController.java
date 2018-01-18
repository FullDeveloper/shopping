package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsSpecProperty;
import com.emed.shopping.dao.model.admin.goods.ShopGoodsSpecification;
import com.emed.shopping.dao.model.admin.system.ShopAccessory;
import com.emed.shopping.service.admin.goods.GoodsSpecPropertyService;
import com.emed.shopping.service.admin.goods.GoodsSpecificationService;
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
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private AccessoryService accessoryService;

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
        Map map = new HashMap();
        map.put("offset",offset);
        map.put("limit",limit);
        map.put("order",sort + " " + order);
        List<ShopGoodsSpecification> goodsSpecifications = goodsSpecificationService.selectSpecificationAndPropertyList(map);
        int total = goodsSpecificationService.selectCount(new ShopGoodsSpecification());
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", goodsSpecifications);
        result.put("total", total);
        return result;
    }

    @RequestMapping(value = "/addPage")
    public String addPage(){
        return "/admin/goods/specification/add";
    }

    @RequestMapping(value = "/updatePage")
    public String updatePage(Long id,Model model){
        //查询出规格基本值
        ShopGoodsSpecification specification = goodsSpecificationService.selectByPrimaryKey(id);
        //查询出规格下所有的属性值
        ShopGoodsSpecProperty property = new ShopGoodsSpecProperty();
        property.setSpecificationId(id);
        List<ShopGoodsSpecProperty> properties = goodsSpecPropertyService.select(property,"sort asc");
        //放入model中
        model.addAttribute("specification",specification);
        model.addAttribute("properties",properties);
        model.addAttribute("update","true");
        return "/admin/goods/specification/update";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Object save(HttpServletRequest request,ShopGoodsSpecification specification,Integer count){
        specification.setCreateTime(new Date());
        specification.setDeleteStatus("0");
        goodsSpecificationService.save(specification);
        //处理规格属性
        genericProperty(request,specification.getId(),count);
        return new BaseResult(1,"成功",null);
    }

    @RequestMapping(value = "/deleteSpecification" ,method = RequestMethod.POST)
    @ResponseBody
    public Object deleteSpecification(Long id) {
        //找到这个记录
        ShopGoodsSpecification specification = goodsSpecificationService.selectByPrimaryKey(id);
        if(specification != null){
            //设置为已删除
            specification.setDeleteStatus("1");
            goodsSpecificationService.updateByPrimaryKey(specification);
            //找到对应的属性
            ShopGoodsSpecProperty property = new ShopGoodsSpecProperty();
            property.setSpecificationId(id);
            List<ShopGoodsSpecProperty> properties = goodsSpecPropertyService.select(property);
            List<Long> accessoryIds = new ArrayList<>();
            for(int i=0;i<properties.size() ; i++){
               if(properties.get(i).getSpecificationImageId()!=null){
                   accessoryIds.add(properties.get(i).getSpecificationImageId());
               }
            }
            //更新为已删除状态
            property.setDeleteStatus("1");
            Example example = new Example(ShopGoodsSpecProperty.class) ;
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("specificationId",specification.getId());
            goodsSpecPropertyService.updateByExampleSelective(property,example);
            //删除图片
            if(accessoryIds.size()>0){
                Example accessory = new Example(ShopAccessory.class);
                accessory.createCriteria().andIn("id",accessoryIds);
                ShopAccessory accessoryObj = new ShopAccessory();
                accessoryObj.setDeleteStatus("1");
                accessoryService.updateByExampleSelective(accessoryObj,accessory);
            }
            return new BaseResult(1,"删除成功",null);
        }
        return new BaseResult(1,"删除失败",null);
    }

    @RequestMapping(value = "/deleteProperty",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteProperty(Long id){
        ShopGoodsSpecProperty property = goodsSpecPropertyService.selectByPrimaryKey(id);
        if(property != null){
            //删除图片
            if(property.getSpecificationImageId() != null){
                accessoryService.deleteByPrimaryKey(property.getSpecificationImageId());
            }
            //删除属性
            goodsSpecPropertyService.deleteByPrimaryKey(id);
            return new BaseResult(1,"删除成功",null);
        }
        return new BaseResult(1,"删除失败,数据库中找不到Id为"+id+"对应的规格属性!",null);
    }

    private void genericProperty(HttpServletRequest request,Long id,Integer count){
        for(int i=1;count != null && i<=count;i++){
            Integer sequence = Integer.parseInt(request.getParameter("sequence_"+i));
            String value = CommonUtil.nullToString(request.getParameter("value_"+i));
            if(StringUtils.isEmpty(sequence) || StringUtils.isEmpty(value)){
                continue;
            }
            Long propertyId = CommonUtil.nullToLong(request.getParameter("id_"+i));
            ShopGoodsSpecProperty property = null;
            if(!StringUtils.isEmpty(propertyId)){
                property = goodsSpecPropertyService.selectByPrimaryKey(propertyId);
            }else{
                property = new ShopGoodsSpecProperty();
            }
            property.setSpecificationId(id);
            property.setCreateTime(new Date());
            property.setSort(sequence);
            property.setValue(value);
            String uploadFilePath = sysConfigService.getSysConfig().getUploadFilePath();
            String saveFilePathName = request.getSession().getServletContext().getRealPath("/")+uploadFilePath+ File.separator + "spec";
            Map map = new HashMap();
            String fileName = "";
            ShopAccessory accessory = null;
            if(property.getSpecificationImageId() != null){
                accessory = accessoryService.selectByPrimaryKey(property.getSpecificationImageId());
                if(!StringUtils.isEmpty(accessory.getName())){
                    fileName = accessory.getName();
                }
            }
            try {
                //上传文件图片
                map = CommonUtil.saveFileToServer(request, "specImage_" + i,
                        saveFilePathName, fileName, null);
                if(fileName.equals("")){
                    //代表已经上传到服务器上
                    if (map.get("fileName") != "") {
                        ShopAccessory specImage = new ShopAccessory();
                        specImage.setName(CommonUtil.nullToString(map.get("fileName")));
                        specImage.setExt(CommonUtil.nullToString(map.get("mime")));
                        specImage.setSize((int)CommonUtil.nullToFloat(map.get("fileSize")));
                        specImage.setPath(uploadFilePath + "/spec");
                        specImage.setWidth(CommonUtil.nullToInt(map.get("width")));
                        specImage.setHeight(CommonUtil.nullToInt(map.get("height")));
                        specImage.setCreateTime(new Date());
                        this.accessoryService.save(specImage);
                        property.setSpecificationImageId(specImage.getId());
                    }
                } else {//代表这个属性已经有对应的图片信息了
                    accessory.setName(CommonUtil.nullToString(map.get("fileName")));
                    accessory.setExt(CommonUtil.nullToString(map.get("mime")));
                    accessory.setSize((int)CommonUtil.nullToFloat(map.get("fileSize")));
                    accessory.setPath(uploadFilePath + "/spec");
                    accessory.setWidth(CommonUtil.nullToInt(map.get("width")));
                    accessory.setHeight(CommonUtil.nullToInt(map.get("height")));
                    accessory.setCreateTime(new Date());
                    this.accessoryService.save(accessory);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            goodsSpecPropertyService.save(property);
        }
    }


}
