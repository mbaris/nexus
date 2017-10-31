package io.baris.nexus.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.baris.nexus.dto.TwitterStatus;
import org.elasticsearch.action.index.IndexResponse;

public interface TwitterStatusRepository {

    IndexResponse save(TwitterStatus twitterStatus) throws JsonProcessingException;

    void delete(TwitterStatus twitterStatus);

    TwitterStatus findOne(String id);

    Iterable<TwitterStatus> findAll();

}
