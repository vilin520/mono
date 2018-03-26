package com.mo.common.quartz;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 定时任务
 */
@Service
public class QuartzService {
	private Logger logger = Logger.getLogger(QuartzService.class);

	
	public void test(){
		logger.error("定时器执行了!");
	}
}