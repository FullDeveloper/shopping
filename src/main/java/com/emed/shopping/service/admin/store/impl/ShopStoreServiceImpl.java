package com.emed.shopping.service.admin.store.impl;

import com.emed.shopping.base.BaseResult;
import com.emed.shopping.base.BaseServiceImpl;
import com.emed.shopping.dao.mapper.admin.store.ShopStoreMapper;
import com.emed.shopping.dao.model.admin.store.ShopStore;
import com.emed.shopping.service.admin.store.ShopStoreService;
import com.emed.shopping.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
@Service
public class ShopStoreServiceImpl extends BaseServiceImpl<ShopStore> implements ShopStoreService {
    @Autowired
    private ShopStoreMapper shopStoreMapper;
    @Override
    public BaseResult updateStoreInfo(HttpServletRequest request) {
        ShopStore shopStore = new ShopStore();
        shopStore.setId(Long.parseLong(request.getParameter("id")));
        if(request.getParameter("recommend")!=null)
            shopStore.setStoreRecommend(request.getParameter("recommend").equals("on")?"1":"2");
        if(!request.getParameter("Village").equals("0"))
            shopStore.setAreaId(Long.parseLong(request.getParameter("Village")));
        if(request.getParameter("cardApprove")!=null)
            shopStore.setCardApprove(request.getParameter("cardApprove").equals("实名认证")?"1":"0");
        if(request.getParameter("realstoreApprove")!=null)
            shopStore.setRealstoreApprove(request.getParameter("realstoreApprove").equals("实体店铺认证")?"1":"0");
        shopStore.setStoreName(request.getParameter("storeName"));
        shopStore.setStoreOwer(request.getParameter("storeOwer"));
        shopStore.setScId(Long.parseLong(request.getParameter("className")));
        shopStore.setStoreAddress(request.getParameter("storeAddress"));
        shopStore.setStoreZip(request.getParameter("storeZip"));
        shopStore.setStoreTelephone(request.getParameter("storeTelephone"));
        shopStore.setValidity(DateUtils.parseDate(request.getParameter("validity")));
        shopStore.setStoreStatus(Integer.parseInt(request.getParameter("storeStatus")));
        int i = shopStoreMapper.updateByPrimaryKeySelective(shopStore);
        if (i!=0){
            return new BaseResult(200,"修改成功!",shopStore);
        }else{
            return new BaseResult(400,"修改失败,请联系管理员!",shopStore);
        }

    }
}
