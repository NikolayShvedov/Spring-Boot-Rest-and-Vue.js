package ru.develop.springrest.initialize;

import lombok.experimental.UtilityClass;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

@UtilityClass
public class Postgres {

  public final static String DATA_BASE_NAME = "db_example";
  public final static String USER_NAME = "postgres";
  public final static String PASSWORD = "1234";

  public static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:13")
    .withDatabaseName(DATA_BASE_NAME)
    .withUsername(USER_NAME)
    .withPassword(PASSWORD);

  public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      TestPropertyValues.of(
        "spring.datasource.url="+container.getJdbcUrl(),
        "spring.datasource.password="+container.getPassword()
      ).applyTo(applicationContext);
    }
  }
}
