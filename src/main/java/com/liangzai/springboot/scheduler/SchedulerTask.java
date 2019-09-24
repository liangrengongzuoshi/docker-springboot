package com.liangzai.springboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	private int count = 0;

	@Scheduled(cron = "0 */10 * * * ?")
	private void process() {
		System.out.println("scheduler task runing  " + (count++));
	}

}
