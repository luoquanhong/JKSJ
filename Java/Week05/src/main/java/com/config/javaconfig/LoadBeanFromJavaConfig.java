package com.config.javaconfig;

import com.pojo.CityInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBeanFromJavaConfig {

    @Bean(name = "cityGuangzhou")
    public CityInfo getInstance(){
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityName("Guangzhou");
        cityInfo.setCitySize(200);
        return cityInfo;
    }
}
