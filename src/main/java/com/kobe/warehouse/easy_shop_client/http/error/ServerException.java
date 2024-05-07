package com.kobe.warehouse.easy_shop_client.http.error;

public class ServerException extends RuntimeException{
    public ServerException(String message) {
        super(message);
    }
}
