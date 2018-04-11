package com.jtd.task;

import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

public class SingleMethodInvokingJobDetailFactoryBean extends MethodInvokingJobDetailFactoryBean {

    public SingleMethodInvokingJobDetailFactoryBean(){
        super();
        super.setTargetMethod("autoTask");
        super.setConcurrent(false);
    }
}
