package io.baris.esports.queue.processor;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.baris.esports.dto.TwitterStatus;
import io.baris.esports.queue.service.QueueService;
import io.baris.esports.service.TwitterStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class StatusQueueProcessor implements QueueProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TwitterStatusService twitterStatusService;

    @Autowired
    private QueueService<TwitterStatus> queueService;

    @PostConstruct
    public void init(){
        Thread thread = new Thread(()->{
            while(true) {
                Optional<TwitterStatus> status = queueService.pop();
                if (status.isPresent()) {
                    try {
                        twitterStatusService.save(status.get());
                    } catch (JsonProcessingException e) {
                        logger.error("Could not parse status into json " + status);
                    }
                }else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        logger.error("Interrupted exception",e);
                    }
                }
            }
        });
        thread.start();
    }

}
