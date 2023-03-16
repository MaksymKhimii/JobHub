package ua.khimii.jobhub.filter;

import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class ApplicationFilter implements Filter {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(ApplicationFilter.class.getName());

    public void init(FilterConfig filterConfig) {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        LOGGER.debug("Before URL processing: {} " + req.getRequestURI());
        chain.doFilter(req, response);
        LOGGER.debug("After URL processing: {} " + req.getRequestURI());
    }

    public void destroy() {

    }
}
