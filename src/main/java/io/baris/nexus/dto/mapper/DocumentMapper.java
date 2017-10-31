package io.baris.nexus.dto.mapper;

import io.baris.nexus.dto.BaseDocument;

public interface DocumentMapper<T extends BaseDocument, Y> {
    T generateDocument(Y entity);
}
