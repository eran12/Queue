package com.example.demo.service;

import com.example.demo.configuration.Properties;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.InvalidParameterException;

/**
 * @author Eran Eichenbaum - 03/11/2021.
 */
@SpringBootTest
public class ServiceTest {
    @Autowired
    private Properties properties;

    private QueueService queueService;

    @BeforeEach
    void beforeEach() {
        this.queueService = new QueueService(properties);
    }

    @Test
    void testAddToQueue() {
        queueService.addToQueue("test", "test");
        queueService.addToQueue("test", "test");
        queueService.addToQueue("test", "test");
        queueService.addToQueue("test", "test");
        queueService.addToQueue("test", "test");
        queueService.addToQueue("test", "test_2");
        Assertions.assertThat(queueService.getSnapshot("test").size()).isEqualTo(5);
        Assertions.assertThat(queueService.getSnapshot("test_2").size()).isEqualTo(1);
        queueService.removeFromQueue("test");
        Assertions.assertThat(queueService.getSnapshot("test").size()).isEqualTo(4);
    }

    @Test
    void testAddDifferentObjsToQueue() throws JSONException {
        queueService.addToQueue("test", "test");
        queueService.addToQueue(1, "test");
        queueService.addToQueue(new JSONObject().put("value", "eran test"), "test");
        queueService.addToQueue(false, "test");
        queueService.removeFromQueue("test");
        Assertions.assertThat(queueService.getSnapshot("test").size()).isEqualTo(3);
    }

    @Test
    void testGetSnapshotException() {
        try {
            queueService.getSnapshot("");
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(InvalidParameterException.class);
        }
    }

    @Test
    void testAddToQueueException() {
        try {
            queueService.addToQueue("", "");
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(InvalidParameterException.class);
        }
    }

    @Test
    void testRemoveFromQueueException() {
        try {
            queueService.removeFromQueue("");
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(InvalidParameterException.class);
        }
    }

    @Test
    void testRemoveFromQueueFail() {
        try {
            queueService.addToQueue("", "test");
            queueService.removeFromQueue("test");
            queueService.removeFromQueue("test");
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(InvalidParameterException.class);
        }
    }
}
