package io.baris.esports.stream.twitter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.baris.esports.dto.TwitterStatus;
import io.baris.esports.dto.mapper.TwitterStatusMapper;
import io.baris.esports.service.TwitterStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Status;

@Component
public class TwitterStatusInterceptor extends AbstractTwitterStatusInterceptor {

    @Autowired
    private TwitterStatusService twitterStatusService;

    @Autowired
    private TwitterStatusMapper twitterStatusMapper;

    @Override
    public void onStatus(Status status) {
        TwitterStatus twitterStatus = twitterStatusMapper.generateDocument(status);

        try {
            twitterStatusService.save(twitterStatus);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
