package com.hostfully.booking.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.hostfully.booking.entities"})
@EnableJpaRepositories(basePackages = {"com.hostfully.booking.repositories"})
@AllArgsConstructor
public class DBConfig {
}
