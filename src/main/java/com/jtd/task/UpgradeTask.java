package com.jtd.task;

import com.jtd.task.SingleAutoTask;
import com.jtd.service.UserAttendsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UpgradeTask extends SingleAutoTask{
	
	private final Logger logger = LoggerFactory.getLogger(UpgradeTask.class);

    @Autowired
    private UserAttendsService userAttendsService;
    
    public void begin() throws Exception {
        try {
        	logger.info("------开始升级 ------ ");
            Thread.sleep(1000);
            userAttendsService.upgrade();
            logger.info("------升级 结束------");
        }catch (Exception e){
        	logger.info("升级出错" + e.getMessage());
        }
    }

}
