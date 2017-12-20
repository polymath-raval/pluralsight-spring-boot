package pluralsight.demo.pluralsightzuulapiproxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;

public class ProxyFilter extends ZuulFilter{

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 2;
  }

  @Override
  public boolean shouldFilter() {
    RequestContext requestContext = RequestContext.getCurrentContext();
    String param = requestContext.getRequest().getParameter("source");
    return "mobile".equalsIgnoreCase(param);
  }

  @Override
  public Object run() {
    System.out.println("calling a filter");
    return null;
  }
}
