package com.wang.springbootwebdemo.config;

import com.wang.springbootwebdemo.component.LoginHandlerInterceptor;
import com.wang.springbootwebdemo.component.myLocalResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 对Spring boot的拓展
 */
@Configuration
public class addMyViewHandler implements WebMvcConfigurer {

    /**
     * 方法一
     * 拓展mvc默认配置 添加自己的视图解析
     * @return
     */
//    @Bean
//    public WebMvcConfigurerAdapter myWebMvcConfigurer(){
//        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/login.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("display");
//            }
//        };
//        return adapter;
//    }

    /**
     * 方法二
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 切换语言
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new myLocalResolver();
    }

    /**
     * 拦截器
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/user/*"
                ,"/**/*.js","/**/*.png","/**/*.svg","/**/*.css","/webjars/**");
    }
}
