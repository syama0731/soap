package jp.co.terasoluna.manual.endpoint;

import jp.co.terasoluna.GetItemRequest;
import jp.co.terasoluna.GetItemResponse;
import jp.co.terasoluna.manual.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ItemEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/rest-soap-web";
    
    @Autowired
    private ItemRepository itemRepository;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetItemRequest")
    @ResponsePayload
    public GetItemResponse getItem(@RequestPayload GetItemRequest request) {
        GetItemResponse response = itemRepository.selectOne(request.getId());
        try {
            // Timeout Test
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }
}
