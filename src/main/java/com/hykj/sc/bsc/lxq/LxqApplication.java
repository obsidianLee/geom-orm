package com.hykj.sc.bsc.lxq;

import com.hykj.sc.bsc.lxq.repository.GridDORepository;
import com.hykj.sc.bsc.lxq.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author	ylyue
 * @since	2019年9月25日
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.hykj.sc.bsc.lxq"})
public class LxqApplication implements ApplicationRunner {

	@Autowired
	GridService service;
	@Autowired
	GridDORepository gridRepository;

	public static void main(String[] args) {
		SpringApplication.run(LxqApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) {
	}
}
