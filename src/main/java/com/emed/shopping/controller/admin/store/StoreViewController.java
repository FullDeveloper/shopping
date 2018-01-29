package com.emed.shopping.controller.admin.store;

import com.emed.shopping.dao.model.admin.store.ShopStore;
import com.emed.shopping.service.admin.store.ShopStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 周润斌
 * @Date: create in 上午 16:00 2018/1/26 0026
 * @Description:
 */
@Controller
public class StoreViewController {

    @Autowired
    private ShopStoreService shopStoreService;

    @RequestMapping(value = "/storeHead.htm")
    public String store_head(Long id,Model model) {
        ShopStore store = shopStoreService.selectByPrimaryKey(id);
        model.addAttribute("store",store);
        return "/web/store_head";
    }

}
