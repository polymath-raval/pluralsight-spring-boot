package pluralsight.demo.pluralsightzuulapiproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import pluralsight.demo.pluralsightzuulapiproxy.filter.EndPostFilter;
import pluralsight.demo.pluralsightzuulapiproxy.filter.ProxyFilter;
import pluralsight.demo.pluralsightzuulapiproxy.filter.StartPreFilter;

@EnableZuulProxy
@SpringBootApplication
public class PluralsightZuulApiproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightZuulApiproxyApplication.class, args);
	}

	@Bean
	public ProxyFilter proxyFilter(){
		return new ProxyFilter();
	}

	@Bean
	public StartPreFilter startPreFilter(){
		return new StartPreFilter();
	}

	@Bean
	public EndPostFilter endPostFilter(){
		return new EndPostFilter();
	}
}
