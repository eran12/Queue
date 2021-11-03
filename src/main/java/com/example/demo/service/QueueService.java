package com.example.demo.service;

import com.example.demo.bean.Queue;
import com.example.demo.configuration.Properties;
import com.example.demo.interfaces.IQueue;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eran Eichenbaum - 03/11/2021.
 */
@Service
public class QueueService implements IQueue {
    private final Queue queue;

    public QueueService(Properties properties) {
        this.queue = new Queue(properties.getSize());
    }

    @Override
    public List<Object> getSnapshot(String queueName) {
        return this.queue.getSnapshot(queueName);
    }

    @Override
    public void addToQueue(Object obj, String queueName) {
        this.queue.enqueue(obj, queueName);
    }

    @Override
    public void removeFromQueue(String queueName) {
        this.queue.dequeue(queueName);
    }
}
