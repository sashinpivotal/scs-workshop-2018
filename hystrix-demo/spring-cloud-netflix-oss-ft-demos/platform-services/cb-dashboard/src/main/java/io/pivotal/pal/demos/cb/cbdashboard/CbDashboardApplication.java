package io.pivotal.pal.demos.cb.cbdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class CbDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(CbDashboardApplication.class, args);
	}
}
