package jp.co.terasoluna.batch.sample.b000001.blogic;

import jp.co.terasoluna.GetItemRequest;
import jp.co.terasoluna.GetItemResponse;
import jp.terasoluna.fw.batch.blogic.BLogic;
import jp.terasoluna.fw.batch.blogic.vo.BLogicParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class B000001BLogic implements BLogic {

    private static Logger log = LoggerFactory.getLogger(B000001BLogic.class);
    
    @Autowired
    protected WebServiceTemplate webServiceTemplate;

    public int execute(BLogicParam param) {
        
        GetItemRequest request = new GetItemRequest(){{
           setId(2); 
        }};
        
        try {
            GetItemResponse response = (GetItemResponse) webServiceTemplate.marshalSendAndReceive(request);
            
            System.out.println("Response ID : " + response.getId());
            System.out.println("Response Price : " + response.getPrice());
        } catch (WebServiceIOException e) {
            // server has sleep time 10s
            System.out.println("timeout occur");
        }
        
        return 0;
    }
}
