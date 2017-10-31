package io.baris.nexus.queue.service;

import io.baris.nexus.dto.TwitterStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class InMemoryStatusQueueService implements QueueService<TwitterStatus> {

    private BlockingQueue<TwitterStatus> sharedQueue = new LinkedBlockingQueue<>();

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void push(TwitterStatus status) {
        boolean offer = sharedQueue.offer(status);
        if(!offer){
            logger.warn("Shared queue might be full. Current size:" + sharedQueue.size());
        }
    }

    @Override
    public Optional<TwitterStatus> pop() {
        return Optional.ofNullable(sharedQueue.poll());
    }
}
