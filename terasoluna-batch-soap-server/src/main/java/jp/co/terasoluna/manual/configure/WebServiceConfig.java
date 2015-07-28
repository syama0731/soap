package jp.co.terasoluna.manual.configure;

import java.util.ArrayList;
import java.util.List;

import jp.co.terasoluna.manual.filter.PrintFilter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }
    
    @Bean(name = "item")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema itemSchema) {
        DefaultWsdl11Definition wsdl11Defition = new DefaultWsdl11Definition();
        wsdl11Defition.setPortTypeName("ItemPort");
        wsdl11Defition.setLocationUri("/ws");
        wsdl11Defition.setTargetNamespace("http://localhost:8080/rest-soap-web");
        wsdl11Defition.setSchema(itemSchema);
        return wsdl11Defition;
    }
    
    @Bean
    public FilterRegistrationBean printFilter(){
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        PrintFilter printFilter = new PrintFilter();
        filterRegBean.setFilter(printFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        filterRegBean.setUrlPatterns(urlPatterns);
        return filterRegBean;
    }
    
    @Bean
    public XsdSchema itemSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/item.xsd"));
    }
}
