package com.emed.shopping.controller.admin.store;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.dao.mapper.admin.system.SysConfigMapper;
import com.emed.shopping.dao.model.admin.system.ShopSysConfig;
import com.emed.shopping.service.admin.system.SysConfigService;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by YeFei on  2018/1/25 0025  上午 11:04 .
 * Description:商铺信用控制层
 */
@Controller
@RequestMapping(value = "/store/credit")
public class StoreCreditController {

    @Autowired
    private SysConfigMapper sysConfigMapper;
    @Autowired
    private SysConfigService sysConfigService;

    @RequestMapping(value = "/index")
    public String toCredit(Model model){
        List<ShopSysConfig> shopSysConfigs = sysConfigMapper.selectAll();
        if (shopSysConfigs.size()!=0){
            String creditRules = shopSysConfigs.get(0).getCreditRules();
            JSONObject jsonObject = JSONObject.fromObject(creditRules);
            model.addAttribute("storeAllow",shopSysConfigs.get(0).getStoreAllow().equals("0")?false:true);
            model.addAttribute("creditRules",jsonObject);
        }
        return "/admin/store/credit/index";
    }

    /**
     * 修改信用积分等级制度
     * @param map
     * @return
     */
    @RequestMapping(value = "/commitCredit")
    @ResponseBody
    public BaseResult commitCredit(@RequestParam Map map){
        JSONObject jsonObject = JSONObject.fromObject(map);
        String creditRule = jsonObject.toString();
        List<ShopSysConfig> shopSysConfigs = sysConfigMapper.selectAll();
        int key;
        if (shopSysConfigs.size()!=0) {
            shopSysConfigs.get(0).setCreditRules(creditRule);
            key = sysConfigService.updateByPrimaryKeySelective(shopSysConfigs.get(0));
        }else {
            ShopSysConfig sysConfig = new ShopSysConfig();
            sysConfig.setCreditRules(creditRule);
            key = sysConfigService.insert(sysConfig);
        }
        if (key!=0)
            return new BaseResult(200,"修改成功!",null);
        else
            return new BaseResult(400,"修改失败!",null);
    }

    /**
     * 是否开启"申请店铺"功能
     * @param map
     * @return
     */
    @RequestMapping(value = "/changeSetNewStore")
    @ResponseBody
    public BaseResult changeSetNewStore(@RequestParam Map map){
        List<ShopSysConfig> shopSysConfigs = sysConfigMapper.selectAll();
        int key;
        if (shopSysConfigs.size()!=0) {
            shopSysConfigs.get(0).setStoreAllow(map.get("flag").equals("false")?"0":"1");
            key = sysConfigService.updateByPrimaryKeySelective(shopSysConfigs.get(0));
        }else {
            ShopSysConfig sysConfig = new ShopSysConfig();
            sysConfig.setStoreAllow(map.get("flag").equals("false")?"0":"1");
            key = sysConfigService.insert(sysConfig);
        }
        if (key!=0)
            return new BaseResult(200,"修改成功!",null);
        else
            return new BaseResult(400,"修改失败!",null);
    }


}
