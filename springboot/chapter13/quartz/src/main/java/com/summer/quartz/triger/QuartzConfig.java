package com.summer.quartz.triger;

import com.summer.quartz.job.MyJob1;
import com.summer.quartz.job.MyJob2;
import org.quartz.JobDataMap;
import org.quartz.SchedulerFactory;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

/**
 * @Author: Renp
 * @Date: 2022/05/16 20:53
 */
@Configuration
public class QuartzConfig {
    @Bean
    MethodInvokingJobDetailFactoryBean jobDetail01(){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myJob1");
        bean.setTargetMethod("sayHello");
        return bean;
    }

    @Bean
    JobDetailFactoryBean jobDetail02(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(MyJob2.class);
        JobDataMap map = new JobDataMap();
        map.put("name", "sumer");
        bean.setJobDataMap(map);
        return bean;
    }

    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(jobDetail01().getObject());
        bean.setRepeatCount(3);
        bean.setRepeatInterval(1000);
        return bean;
    }

    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetail02().getObject());
        bean.setCronExpression("0/5 * * * * ?");
        return bean;
    }

    @Bean
    SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
        return bean;
    }
}
