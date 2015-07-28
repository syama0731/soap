package jp.co.terasoluna.manual.repository;

import jp.co.terasoluna.GetItemResponse;

public interface ItemRepository {

    GetItemResponse selectOne(int id);
}
