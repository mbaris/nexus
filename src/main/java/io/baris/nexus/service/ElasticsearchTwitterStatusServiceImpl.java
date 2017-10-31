package io.baris.nexus.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.baris.nexus.dto.TwitterStatus;
import io.baris.nexus.elasticsearch.TwitterStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticsearchTwitterStatusServiceImpl implements TwitterStatusService {

    private Logger logger = LoggerFactory.getLogger(ElasticsearchTwitterStatusServiceImpl.class);

    @Autowired
    private TwitterStatusRepository esRepository;

    @Override
    public void save(TwitterStatus twitterStatus) throws JsonProcessingException {
        logger.debug("Indexing: "+ twitterStatus);
        esRepository.save(twitterStatus);
    }

    @Override
    public void delete(TwitterStatus twitterStatus) {
        esRepository.delete(twitterStatus);
    }

    @Override
    public TwitterStatus findOne(String id) {
        return esRepository.findOne(id);
    }

    @Override
    public Iterable<TwitterStatus> findAll() {
        return esRepository.findAll();
    }
}
