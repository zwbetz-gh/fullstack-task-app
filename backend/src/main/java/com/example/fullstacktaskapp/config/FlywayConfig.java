package com.example.fullstacktaskapp.config;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class FlywayConfig {

  @Value("${custom.flyway.clean}")
  private boolean customFlywayClean;

  @Value("${custom.flyway.migrate}")
  private boolean customFlywayMigrate;

  @Bean
  public FlywayMigrationStrategy flywayMigrationStrategy() {
    return flyway -> {
      if (customFlywayClean) {
        log.info("Enabling database clean");
        flyway.clean();
      } else {
        log.info("Skipping database clean");
      }

      if (customFlywayMigrate) {
        log.info("Enabling database migrate");
        flyway.migrate();
      } else {
        log.info("Skipping database migrate");
      }
    };
  }
}
