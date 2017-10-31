package io.baris.nexus.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.baris.nexus.dto.TwitterStatus;

public interface TwitterStatusService {

    void save(TwitterStatus twitterStatus) throws JsonProcessingException;

    void delete(TwitterStatus twitterStatus);

    TwitterStatus findOne(String id);

    Iterable<TwitterStatus> findAll();
}
