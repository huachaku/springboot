package com.summer.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Author: Renp
 * @Date: 2022/05/16 20:44
 */
public class MyJob2 extends QuartzJobBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("MyJob2" + name + new Date());
    }
}
