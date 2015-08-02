package jp.co.terasoluna.manual.filter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName="printFilter", urlPatterns="/*")
public class PrintFilter implements Filter {
    
    private static Logger logger = LoggerFactory.getLogger(PrintFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("initialize PrintFilter");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequestWrapper newRequest = new HttpServletRequestWrapperEnableUsingStream((HttpServletRequest) request);
        
        BufferedInputStream bis = new BufferedInputStream(newRequest.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis));
        
        String line = null;
        StringBuilder builder = new StringBuilder();
        
        while((line = reader.readLine()) != null) {
            builder.append(line);
        }
        
        logger.info("Request Body : {}", builder.toString());
        
        chain.doFilter(newRequest, response);
    }

    public void destroy() {
        
    }

}
