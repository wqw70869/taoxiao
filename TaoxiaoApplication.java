package com.example.taoxiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.alibaba.fastjson.support.spring.FastjsonSockJsMessageCodec;

@SpringBootApplication
public class TaoxiaoApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(TaoxiaoApplication.class, args);
	}
	/**
     *新增此方法
     */
     @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
       // 注意这里要指向原先用main方法执行的Application启动类
       return builder.sources(TaoxiaoApplication.class);
   }

}
