package com.springboot.customization.bootcustomfilters.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet filter to log request and response
 * The logging implementation is pretty native and for demonstration only
 * @author hemant
 *
 */
//@Component
@Order(2)
public class RequestResponseLoggingFilter extends OncePerRequestFilter {

	private final static Logger LOG = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);


	@Override
	public void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
								 final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req =request;
		HttpServletResponse res =  response;
		LOG.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
		chain.doFilter(request, response);
		LOG.info("Logging Response :{}", res.getContentType());
	}

}
