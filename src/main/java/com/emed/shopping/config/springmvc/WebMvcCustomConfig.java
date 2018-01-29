package com.emed.shopping.config.springmvc;

import com.emed.shopping.interceptor.UpmsInterceptor;
import com.emed.shopping.util.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @Author: 周润斌
 * @Date: create in 上午 10:05 2018/1/15 0015
 * @Description:
 */

@Configuration
@EnableWebMvc //开启Spring MVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("**.*controller")
public class WebMvcCustomConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(upmsInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public UpmsInterceptor upmsInterceptor(){
        return new UpmsInterceptor();
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html; charset=utf-8");
        return  viewResolver;
    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(10485760L);
        resolver.setMaxInMemorySize(4096);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry);
        //addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/admin/login");
        registry.addViewController("/403").setViewName("/403");
        registry.addViewController("/404").setViewName("/404");
        registry.addViewController("/error").setViewName("/error");
        registry.addViewController("/500").setViewName("/500");
        registry.addViewController("/top").setViewName("/web/top");
    }
}
