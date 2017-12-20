package pluralsight.demo;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RibbonConfig {

  @Autowired
  IClientConfig clientConfig;

  @Bean
  public IRule getRule(IClientConfig clientConfig){
    return new WeightedResponseTimeRule();
  }
}
