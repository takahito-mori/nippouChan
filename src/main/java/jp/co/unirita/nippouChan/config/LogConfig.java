package jp.co.unirita.nippouChan.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.unirita.nippouChan.infrastructure.log.AccessLoggingFilter;

@Configuration
public class LogConfig {
    @Bean
    public FilterRegistrationBean accessLoggingFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AccessLoggingFilter());
        registration.addUrlPatterns("/*");
        registration.setName("accessLoggingFilter");
        registration.setOrder(Integer.MIN_VALUE + 1);
        return registration;
    }
}
