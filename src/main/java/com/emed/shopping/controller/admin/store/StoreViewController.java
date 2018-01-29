package com.emed.shopping.controller.admin.store;

import com.emed.shopping.dao.model.admin.store.ShopStore;
import com.emed.shopping.service.admin.store.ShopStoreService;
import com.emed.shopping.service.admin.system.SysConfigService;
import com.emed.shopping.util.CommonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Author: 周润斌
 * @Date: create in 上午 16:00 2018/1/26 0026
 * @Description:
 */
@Controller
public class StoreViewController {

    @Autowired
    private ShopStoreService shopStoreService;

    @Autowired
    private SysConfigService sysConfigService;

    @RequestMapping(value = "/storeHead.htm")
    public String store_head(Long id,Model model) {
        ShopStore store = shopStoreService.selectByPrimaryKey(id);
        int storeCreditLevel = getCreditLevel(store.getStoreCredit());
        store.setStoreCredit(storeCreditLevel);
        model.addAttribute("store",store);
        return "/web/store_head";
    }


    private int getCreditLevel(Integer credit){
        String creditRules = sysConfigService.getSysConfig().getCreditRules();
        JSONObject jsonObject = JSONObject.fromObject(creditRules);
        List<Integer> list = new ArrayList<>();
        //将集合中每个阶段的分拿到
        for (Iterator it = jsonObject.keySet().iterator(); it.hasNext(); ) {
            String key = (String)it.next();
            list.add(Integer.parseInt(jsonObject.get(key).toString()));
        }
        //进行排序
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int a = CommonUtil.nullToInt(o1);
                int b = CommonUtil.nullToInt(o2);
                if (a == b) {
                    return 0;
                }
                return a > b ? 1 : -1;
            }
        });
        //没有达到最低分 或者大于最高分  1401>1499 false 1500 < 1499 false
        for(int i=0;i<list.size()-1;i++){
            if(credit > list.get(i) && credit < list.get(i+1)){
                credit = i+1;
            }
        }
        return credit;
    }

}
