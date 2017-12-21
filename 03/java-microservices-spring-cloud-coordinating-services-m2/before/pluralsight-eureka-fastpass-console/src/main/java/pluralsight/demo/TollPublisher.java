package pluralsight.demo;

import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(TollSource.class)
public class TollPublisher {

  Random random = new Random();
  @Bean
  //@InboundChannelAdapter(channel = "fastpassTollChannel", poller = @Poller(fixedDelay = "2000"))
  public MessageSource<Toll> sendTollChange() {
    return () ->
        MessageBuilder
            .withPayload(new Toll("20", "100", LocalDateTime.now().toString()))
            .setHeader("speed", random.nextInt(8) * 10)
            .build();
  }


  class Toll {

    String station;
    String customerId;
    String timeStamp;

    public Toll(String station, String customerId, String timeStamp) {
      this.station = station;
      this.customerId = customerId;
      this.timeStamp = timeStamp;
    }

    public String getStation() {
      return station;
    }

    public void setStation(String station) {
      this.station = station;
    }

    public String getCustomerId() {
      return customerId;
    }

    public void setCustomerId(String customerId) {
      this.customerId = customerId;
    }

    public String getTimeStamp() {
      return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
      this.timeStamp = timeStamp;
    }
  }
}
