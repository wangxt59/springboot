//package com.boot.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import com.boot.interceptor.MyInterceptor;
//
//
///**
// * 
// * @ClassName: MyInterceptor
// * @Description:springboot拦截器配置
// * @author cheng
// * @date 2017年9月19日 下午10:14:48
// */
//@Configuration//表示这是一个配置类
//@EnableWebMvc
//public class MyInterceptorConfig extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    private MyInterceptor myInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 添加拦截器并设置拦截规则
//        // /*表示路径
//        // /**表示路径及其自路径    
//    	registry.addInterceptor(myInterceptor).addPathPatterns("/*");
//    	registry.addInterceptor(myInterceptor).addPathPatterns("/**");
//    }
//
//}
