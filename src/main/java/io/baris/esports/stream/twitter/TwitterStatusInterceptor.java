package io.baris.esports.stream.twitter;

import io.baris.esports.dto.TwitterStatus;
import io.baris.esports.dto.mapper.TwitterStatusMapper;
import io.baris.esports.repository.elasticsearch.ElasticsearchTwitterStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Status;

@Component
public class TwitterStatusInterceptor extends AbstractTwitterStatusInterceptor {

    @Autowired
    private ElasticsearchTwitterStatusRepository elasticsearchTwitterStatusRepository;

    @Autowired
    private TwitterStatusMapper twitterStatusMapper;

    @Override
    public void onStatus(Status status) {
        TwitterStatus twitterStatus = twitterStatusMapper.generateDocument(status);
        elasticsearchTwitterStatusRepository.saveDocument(twitterStatus);
    }
}
