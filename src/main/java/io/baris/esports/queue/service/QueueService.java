package io.baris.esports.queue.service;

import java.util.Optional;

public interface QueueService<T> {

    void push(T t);

    Optional<T> pop();
}
