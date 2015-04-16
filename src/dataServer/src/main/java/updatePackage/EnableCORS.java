package updatePackage;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletException;

/*
 * Enable Cross Origin Resource Sharing (CORS) for the server
 */
@Component
public class EnableCORS implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException,ServletException {
		HttpServletResponse http = (HttpServletResponse) response;
		http.setHeader("Access-Control-Allow-Origin","*");
		http.setHeader("Access-Control-Allow-Methods","GET, OPTIONS");
		http.setHeader("Access-Control-Max-Age","3600");
		http.setHeader("Access-Control-Allow-Headers","x-requested-with");
		fc.doFilter(request, response);
	}
	
	public void init(FilterConfig config) {}
	
	public void destroy() {}
}
