package com.hmxy.manager.config;


import com.hmxy.manager.converter.DateConverter;
import com.hmxy.manager.interceptor.LoginInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * MVC配置拦截器
 */
@SpringBootConfiguration
public class MVCConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInteceptor loginInteceptor;

    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations. Interceptors can be registered to apply
     * to all requests or be limited to a subset of URL patterns.
     * <p><strong>Note</strong> that interceptors registered here only apply to
     * controllers and not to resource handler requests. To intercept requests for
     * static resources either declare a
     * {@link MappedInterceptor MappedInterceptor}
     * bean or switch to advanced configuration mode by extending
     * {@link WebMvcConfigurationSupport
     * WebMvcConfigurationSupport} and then override {@code resourceHandlerMapping}.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(loginInteceptor).addPathPatterns("/**").excludePathPatterns("/static/**");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }
}
