package io.baris.nexus.dto.mapper;

import io.baris.nexus.dto.TwitterStatus;
import org.springframework.stereotype.Service;
import twitter4j.Status;

@Service
public class TwitterStatusMapper implements DocumentMapper<TwitterStatus,Status>{

    @Override
    public TwitterStatus generateDocument(Status status) {
        TwitterStatus twitterStatus = new TwitterStatus();
        twitterStatus.setText(status.getText());
        twitterStatus.setId(status.getId());
        twitterStatus.setCreatedAt(status.getCreatedAt().getTime());
        return twitterStatus;
    }
}
