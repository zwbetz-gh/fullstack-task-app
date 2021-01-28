package com.example.fullstacktaskapp.config;

import java.util.Arrays;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Log4j2
@Configuration
public class FlywayConfig {

  @Autowired
  private Environment environment;

  private static final String CLEAN_DB = "clean-db";
  private static final String MIGRATE_DB = "migrate-db";

  @Bean
  public FlywayMigrationStrategy flywayMigrationStrategy() {
    final List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
    return flyway -> {
      if (activeProfiles.contains(CLEAN_DB)) {
        log.info("{} profile is active. Database will be cleaned", CLEAN_DB);
        flyway.clean();
      } else {
        log.info("{} profile is not active. Database will not be cleaned", CLEAN_DB);
      }

      if (activeProfiles.contains(MIGRATE_DB)) {
        log.info("{} profile is active. Database will be migrated", MIGRATE_DB);
        flyway.migrate();
      } else {
        log.info("{} profile is not active. Database will not be migrated", MIGRATE_DB);
      }
    };
  }
}
