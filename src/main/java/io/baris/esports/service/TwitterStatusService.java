package io.baris.esports.service;

import io.baris.esports.dto.TwitterStatus;

public interface TwitterStatusService {

    TwitterStatus save(TwitterStatus twitterStatus);

    void delete(TwitterStatus twitterStatus);

    TwitterStatus findOne(String id);

    Iterable<TwitterStatus> findAll();
}
