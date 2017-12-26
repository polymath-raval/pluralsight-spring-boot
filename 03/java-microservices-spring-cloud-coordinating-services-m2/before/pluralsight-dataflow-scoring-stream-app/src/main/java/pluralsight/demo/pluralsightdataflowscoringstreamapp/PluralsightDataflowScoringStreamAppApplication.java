package pluralsight.demo.pluralsightdataflowscoringstreamapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableConfigurationProperties(TollReadingProperties.class)
@EnableBinding(Processor.class)
@SpringBootApplication
public class PluralsightDataflowScoringStreamAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightDataflowScoringStreamAppApplication.class, args);
	}

	@Autowired
	private TollReadingProperties tollReadingProperties;

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public TollReading assignScore(TollReading reading){
		System.out.println("input is "+reading);
		int fraudThreshold = tollReadingProperties.getFraudThreshlod();
		int fraudProbability=0;
		if(reading.getStationid() == 110){
			fraudProbability = 30;
		}
		reading.setFraud(fraudProbability > fraudThreshold);
		return reading;
	}
}
