package com.sp.sp_config_server_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpConfigServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpConfigServerAppApplication.class, args);
	}

}
