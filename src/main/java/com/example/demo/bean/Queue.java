package com.example.demo.bean;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Eran Eichenbaum - 03/11/2021.
 */
public class Queue {
    HashMap<String, LinkedList<Object>> queueMap;
    int capacity;

    public Queue(int cap) {
        queueMap = new HashMap<>();
        capacity = cap;
    }

    public void enqueue(Object obj, String queueName) throws InvalidParameterException {
        if (queueName == null || queueName.length() == 0) {
            throw new InvalidParameterException("queue name cannot be null or empty");
        }
        if (!this.queueMap.containsKey(queueName)) {
            this.queueMap.put(queueName, new LinkedList<>());
        }
        List<Object> selectedQueue = this.queueMap.get(queueName);
        if (selectedQueue.size() == capacity) {
            System.out.println("queue is full");
            return;
        }
        selectedQueue.add(obj);
    }

    public void dequeue(String queueName) throws InvalidParameterException {
        if (queueName == null || queueName.length() == 0) {
            throw new InvalidParameterException("queue name cannot be null or empty");
        }
        if (!this.queueMap.containsKey(queueName)) return;
        List<Object> selectedQueue = this.queueMap.get(queueName);
        if (selectedQueue.size() == 0) return;
        selectedQueue.remove(selectedQueue.size() - 1);
    }

    public List<Object> getSnapshot(String queueName) throws InvalidParameterException {
        if (queueName == null || queueName.length() == 0) {
            throw new InvalidParameterException("queue name cannot be null or empty");
        }
        if (this.queueMap.containsKey(queueName)) {
            return this.queueMap.get(queueName);
        } else {
            return new ArrayList<>();
        }
    }
}
