package pluralsight.demo.pluralsightdataflowscoringstreamapp;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("fraud")
public class TollReadingProperties {
  private Integer fraudThreshlod = 10;

  public Integer getFraudThreshlod() {
    return fraudThreshlod;
  }

  public void setFraudThreshlod(Integer fraudThreshlod) {
    this.fraudThreshlod = fraudThreshlod;
  }
}
