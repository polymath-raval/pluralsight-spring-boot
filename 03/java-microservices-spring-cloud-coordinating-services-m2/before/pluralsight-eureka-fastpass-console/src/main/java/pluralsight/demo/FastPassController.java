package pluralsight.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@RibbonClient(name="PLURALSIGHT-FASTPASS-INSTANCE", configuration = RibbonConfig.class)
@Controller
public class FastPassController {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFastPassCustomerDetailsBackup")
	@RequestMapping(path="/customerdetails", params={"fastpassid"})
	public String getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {
		
		//RestTemplate rest = new RestTemplate();
		FastPassCustomer c = restTemplate.getForObject("http://PLURALSIGHT-FASTPASS-INSTANCE/fastpass?fastpassid=" + fastpassid, FastPassCustomer.class);
		System.out.println("retrieved customer details");
		m.addAttribute("customer", c);
		return "console";
	}

	public String getFastPassCustomerDetailsBackup(@RequestParam String fastpassid, Model m) {
		System.out.println("Failover Method Called !!!");
		FastPassCustomer c = new FastPassCustomer();
		c.setFastPassId(fastpassid);
		m.addAttribute("customer", c);
		return "console";
	}
}
