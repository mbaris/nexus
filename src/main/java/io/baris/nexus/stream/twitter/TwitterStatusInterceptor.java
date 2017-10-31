package io.baris.nexus.stream.twitter;

import io.baris.nexus.dto.TwitterStatus;
import io.baris.nexus.dto.mapper.TwitterStatusMapper;
import io.baris.nexus.queue.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Status;

@Component
public class TwitterStatusInterceptor extends AbstractTwitterStatusInterceptor {

    @Autowired
    private TwitterStatusMapper twitterStatusMapper;

    @Autowired
    private QueueService<TwitterStatus> queueService;

    @Override
    public void onStatus(Status status) {
        TwitterStatus twitterStatus = twitterStatusMapper.generateDocument(status);
        queueService.push(twitterStatus);
    }
}
