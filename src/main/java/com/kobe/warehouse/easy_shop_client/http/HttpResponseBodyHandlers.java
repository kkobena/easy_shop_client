package com.kobe.warehouse.easy_shop_client.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpResponseBodyHandlers {
    // Example custom body handler for JSON response
  private static  final   ObjectMapper objectMapper = new ObjectMapper();


    // Example JSON parsing method
    public static <T> T parseJson(String responseBody, Class<T> responseType) {
        // Implement JSON parsing logic here
        // This is just a placeholder
        try {
            return objectMapper.readValue(responseBody,responseType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
