package com.jtd.task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class SingleAutoTask {

    private final Logger logger = LoggerFactory.getLogger(SingleAutoTask.class);

    public abstract void begin() throws Exception;

    public synchronized void autoTask() throws Exception{
        String hostIP = "";
        try {
            hostIP = InetAddress.getLocalHost().getHostAddress();
            logger.info("服务器IP ---> " + hostIP);
        } catch (UnknownHostException e) {
            logger.error(e.getMessage(), e);
        }
        
    }

}
