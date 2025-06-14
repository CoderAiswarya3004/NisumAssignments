import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestLoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Request URL: " + httpRequest.getRequestURL());

        chain.doFilter(request, response);
    }

    public void destroy() {}
}
