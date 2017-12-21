package pluralsight.demo.pluralsightstreamtollintake;

import org.apache.tomcat.jni.Proc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Sink.class)
//@EnableBinding(Processor.class)
@SpringBootApplication
public class PluralsightStreamTollintakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightStreamTollintakeApplication.class, args);
	}

	@StreamListener(value = Sink.INPUT, condition = "headers['speed'] > 40")
	//@ServiceActivator(inputChannel = Sink.INPUT)
	//@StreamListener(Processor.INPUT)
	//@SendTo(Processor.OUTPUT)
	public void logGreaterThan40(String msg){
		System.out.println("Speed greater than 40 "+msg);
	}


	@StreamListener(value = Sink.INPUT, condition = "headers['speed'] <= 40")
	public void logLessThan40(String msg){
		System.out.println("Speed less than 40 "+msg);
	}
}
