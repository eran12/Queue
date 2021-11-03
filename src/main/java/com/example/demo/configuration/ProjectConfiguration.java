package com.example.demo.configuration;

import com.example.demo.service.QueueService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Eran Eichenbaum - 03/11/2021.
 */
@Configuration
public class ProjectConfiguration {

    @Bean
    QueueService getQueueService(Properties properties) {
        return new QueueService(properties);
    }

}
