package com.config;

import com.pojo.CityInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBeanFromJavaConfig {

    @Bean
    public CityInfo getInstance(){
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityName("Guangzhou");
        cityInfo.setCitySize(200);
        return cityInfo;
    }
}
