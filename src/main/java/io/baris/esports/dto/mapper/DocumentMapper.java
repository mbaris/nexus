package io.baris.esports.dto.mapper;

import io.baris.esports.dto.BaseDocument;

public interface DocumentMapper<T extends BaseDocument, Y> {
    T generateDocument(Y entity);
}
