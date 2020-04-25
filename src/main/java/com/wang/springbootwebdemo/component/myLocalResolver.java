package com.wang.springbootwebdemo.component;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 定义自己的LocaleResolver
 * 用于切换中英文
 */
public class myLocalResolver  implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取到浏览器传递的参数
        String parameter = request.getParameter("l");
        Locale locale=null;
        if (!StringUtils.isEmpty(parameter)){
            String[] s = parameter.split("_");
            locale = new Locale(s[0],s[1]);
        }else {
            locale = Locale.getDefault();
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
