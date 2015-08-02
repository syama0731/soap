package jp.co.terasoluna.manual.filter;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServletRequestWrapperEnableUsingStream extends HttpServletRequestWrapper {
    
    public byte[] inputStreamByteArray;
    
    private static Logger logger = LoggerFactory.getLogger(HttpServletRequestWrapper.class);

    public HttpServletRequestWrapperEnableUsingStream(HttpServletRequest request) {
        super(request);
        
        try {
            BufferedInputStream bis = new BufferedInputStream(request.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            byte[] byteArray = new byte[1024 * 8];
            int length = 0;
            while((length = bis.read(byteArray)) != -1) {
                baos.write(byteArray, 0, length);
            }
            
            this.inputStreamByteArray = baos.toByteArray();
            
        } catch (IOException e) {
            logger.error("can't read servletInputStream", e);
        }
    }
    
    @Override
    public ServletInputStream getInputStream() {
        return new ServletInputStreamWrapper(new ByteArrayInputStream(inputStreamByteArray));
    }
    
    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(new ServletInputStreamWrapper(new ByteArrayInputStream(inputStreamByteArray))));
    }
    
    protected class ServletInputStreamWrapper extends ServletInputStream {
        
        private InputStream inputStream;

        ServletInputStreamWrapper(InputStream inputStream) {
            this.inputStream = inputStream;
        }
        
        @Override
        public int read() throws IOException {
            return this.inputStream.read();
        }
        
    }

}
