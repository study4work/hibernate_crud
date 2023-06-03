package com.lysenko.config;

import org.flywaydb.core.Flyway;

public class FlywayConfig {

   public static void startMigration() {
          Flyway flyway = Flyway.configure()
               .dataSource("jdbc:postgresql://localhost:5432/crud", "postgres", "Qq111111")
               .locations("classpath:db/migration")
               .load();

          //запуск миграций
            flyway.migrate();
       }
}
