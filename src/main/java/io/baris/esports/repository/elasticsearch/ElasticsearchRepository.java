package io.baris.esports.repository.elasticsearch;

import io.baris.esports.dto.BaseDocument;
import io.baris.esports.repository.Repository;

public interface ElasticsearchRepository<T extends BaseDocument> extends Repository {

    T getDocument(String id);

    void saveDocument(T entity);

    void deleteDocument(String id);
}
