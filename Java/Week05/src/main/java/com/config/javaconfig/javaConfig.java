package com.config.javaconfig;

import com.pojo.CityInfo;
import com.pojo.Klass;
import com.pojo.Student;
import com.service.ISchool;
import com.service.impl.School;
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

    @Bean
    public Student getStudentInstance(){
        return new Student();
    }

    @Bean
    public Klass getKlassInstance(){
        return new Klass();
    }

    @Bean
    public ISchool getSchoolInstance(){
        return new School();
    }
}
