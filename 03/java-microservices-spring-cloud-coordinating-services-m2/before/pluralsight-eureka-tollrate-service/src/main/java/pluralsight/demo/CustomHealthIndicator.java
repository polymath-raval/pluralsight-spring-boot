package pluralsight.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

  int number = -1;
  static final int startNumber = 2;
  static final int endNumber = 5;

  @Override
  public Health health() {
    number++;
    return (startNumber < number && number < endNumber) ?
        Health.down().withDetail("Custom Error Code", number).build() :
        Health.up().withDetail("Custom Sucess Code", number).build() ;
  }
}
