package com.emed.shopping;

import com.emed.shopping.dao.model.admin.goods.ShopGoodsType;
import com.emed.shopping.service.admin.goods.GoodsTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingApplicationTests {

	@Autowired
	private GoodsTypeService goodsTypeService;

	@Test
	public void contextLoads() {
		ShopGoodsType type = new ShopGoodsType();
		type.setName("服装");
		List<ShopGoodsType> cityList =  goodsTypeService.select(type," sort desc");
		for(ShopGoodsType city : cityList){
			System.out.println(city.getName());
			System.out.println(city.getId());
			System.out.println(city.getCreateTime());
		}
	}

}
