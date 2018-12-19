package com.demo181108.userdemo;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class UserdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserdemoApplication.class, args);
	}
}
