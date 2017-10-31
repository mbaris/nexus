package io.baris.esports.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.baris.esports.dto.TwitterStatus;

public interface TwitterStatusService {

    void save(TwitterStatus twitterStatus) throws JsonProcessingException;

    void delete(TwitterStatus twitterStatus);

    TwitterStatus findOne(String id);

    Iterable<TwitterStatus> findAll();
}
