package com.spring.firstapp.config;

import com.spring.firstapp.model.FirstAppEvent;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConfiguration {
    private final KafkaProperties kafkaProperties;

    public KafkaConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean("firstAppContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, FirstAppEvent> firstAppEventContainerFactory() {
        final ConcurrentKafkaListenerContainerFactory<String, FirstAppEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties()));
        return factory;
    }
}
