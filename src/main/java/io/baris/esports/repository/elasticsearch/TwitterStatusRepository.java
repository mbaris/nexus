package io.baris.esports.repository.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.baris.esports.dto.TwitterStatus;
import org.elasticsearch.action.index.IndexResponse;

public interface TwitterStatusRepository {

    IndexResponse save(TwitterStatus twitterStatus) throws JsonProcessingException;

    void delete(TwitterStatus twitterStatus);

    TwitterStatus findOne(String id);

    Iterable<TwitterStatus> findAll();

}
