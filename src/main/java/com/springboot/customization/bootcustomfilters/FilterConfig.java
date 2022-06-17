package com.springboot.customization.bootcustomfilters;

import com.springboot.customization.bootcustomfilters.filters.RequestResponseLoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    // uncomment this and comment the @Component in the filter class definition to register only for a url pattern
     @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestResponseLoggingFilter());

        registrationBean.addUrlPatterns("/users/fetch-user");
        registrationBean.setOrder(2);

        return registrationBean;

    }

}
