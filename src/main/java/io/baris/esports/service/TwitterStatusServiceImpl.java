package io.baris.esports.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.baris.esports.dto.TwitterStatus;
import io.baris.esports.repository.elasticsearch.TwitterStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterStatusServiceImpl implements TwitterStatusService {

    Logger logger = LoggerFactory.getLogger(TwitterStatusServiceImpl.class);

    @Autowired
    private TwitterStatusRepository esRepository;

    @Override
    public void save(TwitterStatus twitterStatus) throws JsonProcessingException {
        logger.info("Indexing: "+ twitterStatus);
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
