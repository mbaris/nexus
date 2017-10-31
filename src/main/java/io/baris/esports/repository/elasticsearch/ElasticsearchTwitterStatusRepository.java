package io.baris.esports.repository.elasticsearch;


import io.baris.esports.dto.TwitterStatus;
import org.springframework.stereotype.Repository;

@Repository
public class ElasticsearchTwitterStatusRepository implements ElasticsearchRepository<TwitterStatus> {

    @Override
    public TwitterStatus getDocument(String id) {
        return null;
    }

    @Override
    public void saveDocument(TwitterStatus entity) {
        System.out.println("Saving" + entity);
    }

    @Override
    public void deleteDocument(String id) {

    }
}
