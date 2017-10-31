package io.baris.esports.service;

import io.baris.esports.dto.TwitterStatus;
import io.baris.esports.repository.elasticsearch.TwitterStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterStatusServiceImpl implements TwitterStatusService {

    @Autowired
    private TwitterStatusRepository esRepository;

    @Override
    public TwitterStatus save(TwitterStatus twitterStatus) {
        return esRepository.save(twitterStatus);
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
