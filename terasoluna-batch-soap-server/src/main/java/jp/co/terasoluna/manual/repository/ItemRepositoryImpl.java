package jp.co.terasoluna.manual.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.terasoluna.GetItemResponse;

@Component
public class ItemRepositoryImpl implements ItemRepository {
    
    private static final List<GetItemResponse> list = new LinkedList<GetItemResponse>();

    static {
        GetItemResponse response1 = new GetItemResponse();
        response1.setId(1);
        response1.setPrice(100);
        list.add(response1);
        
        GetItemResponse response2 = new GetItemResponse();
        response2.setId(2);
        response2.setPrice(200);
        list.add(response2);
        
        GetItemResponse response3 = new GetItemResponse();
        response3.setId(3);
        response3.setPrice(300);
        list.add(response3);
    }
    
    public GetItemResponse selectOne(int id) {
        GetItemResponse result = new GetItemResponse();
        
        for (GetItemResponse response : list) {
            if (response.getId() == id) {
                result = response;
                break;
            }
        }
        
        return result;
    }

}
