package com.zmf.realty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication()
@EnableTransactionManagement()
@EnableWebMvc
@MapperScan("com.zmf.realty.dao")
public class RealtyApplication {
	public static void main(String[] args) {
		SpringApplication.run(RealtyApplication.class, args);
	}
}
