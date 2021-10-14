package com.config.javaconfig;

import com.pojo.CityInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {LoadBeanFromJavaConfig.class})
public class javaConfig {

    @Bean(name = "cityHangzhou")
    public CityInfo getInstance(){
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityName("HangZhou");
        cityInfo.setCitySize(1500);
        return cityInfo;
    }
}
