package com.og.oms;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@MapperScan("com.og.oms.dao")
@SpringBootApplication
public class OmsApplication extends SpringBootServletInitializer {
    private static Logger logger = LoggerFactory.getLogger(OmsApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OmsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OmsApplication.class, args);
        logger.info("服务器启动成功!");
    }
}
