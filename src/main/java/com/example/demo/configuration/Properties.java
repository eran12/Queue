package com.example.demo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Eran Eichenbaum - 03/11/2021.
 */
@Configuration
@ConfigurationProperties(prefix = "queue")
@Getter
@Setter
public class Properties {

    private int size;
}
