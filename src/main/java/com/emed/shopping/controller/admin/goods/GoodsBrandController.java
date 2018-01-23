package com.emed.shopping.controller.admin.goods;

import com.emed.shopping.dao.model.admin.goods.ShopGoodsBrand;
import com.emed.shopping.service.admin.goods.GoodsBrandService;
import com.emed.shopping.service.admin.system.SysConfigService;
import com.emed.shopping.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 周润斌
 * @Date: create in 上午 11:53 2018/1/16 0016
 * @Description: 商品品牌管理控制器
 */
@Controller
@RequestMapping(value = "/goods/brand")
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;
    @Autowired
    private SysConfigService sysConfigService;
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
            @RequestParam(required = false, value = "order") String order) {
        PageInfo<ShopGoodsBrand> pageInfo = goodsBrandService.selectPage(offset, limit, new ShopGoodsBrand(), sort + " " + order);
        Map<String, Object> result = new HashMap<>(2);
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/addPage")
    public String addPage(){

        return "/admin/goods/brand/add";
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(HttpServletRequest request,ShopGoodsBrand shopGoodsBrand){
        String uploadFilePath = sysConfigService.getSysConfig().getUploadFilePath();
        String saveFilePathName = request.getSession().getServletContext().getRealPath("/")+uploadFilePath+ File.separator + "brand";
        try {
            Map map = CommonUtil.saveFileToServer(request, "accessoryImage",
                    saveFilePathName, "", null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
