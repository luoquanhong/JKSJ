package com.starter;

import com.config.javaconfig.javaConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {javaConfig.class})
public class CustomStarter {
}
