package com.emed.shopping;

import com.emed.shopping.dao.mapper.admin.CityMapper;
import com.emed.shopping.dao.model.admin.City;
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
	private CityMapper cityMapper;

	@Test
	public void contextLoads() {
		List<City> cityList =  cityMapper.selectAll();
		for(City city : cityList){
			System.out.println(city.getName());
			System.out.println(city.getId());
			System.out.println(city.getState());
		}
	}

}
