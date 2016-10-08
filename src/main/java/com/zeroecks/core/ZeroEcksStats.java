package com.zeroecks.core;

import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.KatharsisConfigV2;
import org.apache.catalina.filters.RequestDumperFilter;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RestController
@SpringBootApplication
@Import(KatharsisConfigV2.class)
public class ZeroEcksStats {
    @Autowired
    private ResourceRegistry resourceRegistry;

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return new FlywayMigrationStrategy() {
            @Override
            public void migrate(Flyway flyway) {
                flyway.baseline();
            }
        };
    }

    @RequestMapping("/api/resources")
    public Map<?, ?> getResources() {
        final Map<String, String> result = new HashMap<>();
        for (Class<?> clazz : resourceRegistry.getResources().keySet()) {
            result.put(resourceRegistry.getResourceType(clazz), resourceRegistry.getResourceUrl(clazz));
        }
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(ZeroEcksStats.class, args);
    }
}
