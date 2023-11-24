package com.oral.config;

import com.oral.constant.FileConstant;
import com.oral.interceptor.JwtTokenUserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * WebMVC相关配置
 */

@Configuration
public class WebMVCConfig extends WebMvcConfigurationSupport {

    @Resource
    private JwtTokenUserInterceptor jwtTokenUserInterceptor;

    /**
     * 配置jwt拦截器
     *
     * @param registry
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/doctor/**")
                .addPathPatterns("/admin/**")
                .addPathPatterns("/user/**")
                .addPathPatterns("/role")
//                .addPathPatterns("/upload/**")
                .excludePathPatterns("/user/login");
    }


    /**
     * knife4j 配置静态资源映射
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** 配置knife4j 显示文档 */
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        /** 公共部分内容 */
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/nii/**")
                .addResourceLocations("file:" + FileConstant.INPUT_FILE);
    }

    /**
     * 扩展Spring MVC消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建一个消息转换器对象
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        //为消息转换器设置一个对象转换器，对象转换器可以将Java对象转换为Json数据
        converter.setObjectMapper(new JacksonObjectMapper());
        //将消息转换器加入容器中
        converters.add(0,converter);
    }
}
