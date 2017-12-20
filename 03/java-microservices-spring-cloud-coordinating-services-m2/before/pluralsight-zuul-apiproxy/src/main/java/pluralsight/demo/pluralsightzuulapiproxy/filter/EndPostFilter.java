package pluralsight.demo.pluralsightzuulapiproxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class EndPostFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "post";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext context = RequestContext.getCurrentContext();
    Instant startTime = (Instant)context.get("startTime");
    System.out.println("TimeTaken in Micro Seconds "+ ChronoUnit.MICROS.between(startTime, Instant.now()));
    return null;
  }
}
