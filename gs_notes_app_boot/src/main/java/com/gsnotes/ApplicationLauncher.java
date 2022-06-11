package com.gsnotes;

import com.gsnotes.bo.Niveau;
import com.gsnotes.services.INiveauService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.List;

@SpringBootApplication
public class ApplicationLauncher {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationLauncher.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationLauncher.class, args);


	}

}
