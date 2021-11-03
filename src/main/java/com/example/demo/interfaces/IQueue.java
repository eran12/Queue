package com.example.demo.interfaces;

import java.util.List;

/**
 * @author Eran Eichenbaum - 03/11/2021.
 */
public interface IQueue {
    List<Object> getSnapshot(String queueName);

    void addToQueue(Object obj, String queueName);

    void removeFromQueue(String queueName);

}
