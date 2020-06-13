package com.xcz.printer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@MapperScan({ "com.xcz.printer.dao","com.xcz.printer.mapper"})
public class PrinterApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrinterApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PrinterApplication.class, args);
    }
    
}
