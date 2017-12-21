package pluralsight.demo;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastPassRestController {

  Random random = new Random();

  @Autowired
  TollSource mysource;

  @RequestMapping(path = "/toll", method = RequestMethod.POST)
  public String publishMessage(@RequestBody String payLoad){
    System.out.println(payLoad);
    mysource.fastpassToll()
        .send(
            MessageBuilder
                .withPayload(payLoad)
                .setHeader("speed", random.nextInt(8)*10)
                .build());
    return payLoad;
  }
}
