package com.example.demo.web;

import com.example.demo.interfaces.IQueue;
import com.example.demo.service.QueueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Eran Eichenbaum - 03/11/2021.
 */
@RestController
public class QueueWeb implements IQueue {
    QueueService queueService;

    public QueueWeb(QueueService queueService) {
        this.queueService = queueService;
    }

    @Override
    @GetMapping
    public List<Object> getSnapshot(@RequestParam String queueName) {
        return this.queueService.getSnapshot(queueName);
    }

    @PostMapping
    public void addToQueue(@RequestBody Object obj, @RequestParam String queueName) {
        this.queueService.addToQueue(obj, queueName);
    }

    @Override
    @DeleteMapping
    public void removeFromQueue(@RequestParam String queueName) {
        this.queueService.removeFromQueue(queueName);
    }
}
