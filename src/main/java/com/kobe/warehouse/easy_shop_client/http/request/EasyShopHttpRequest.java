package com.kobe.warehouse.easy_shop_client.http.request;

public class EasyShopHttpRequest {
    private String endPoint;
    private Object body;
    private QueryParams queryParams;


    public QueryParams getQueryParams() {
        return queryParams;
    }

    public EasyShopHttpRequest setQueryParams(QueryParams queryParams) {
        this.queryParams = queryParams;
        return this;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public EasyShopHttpRequest setEndPoint(String endPoint) {
        this.endPoint = endPoint;
        return this;
    }



    public Object getBody() {
        return body;
    }

    public EasyShopHttpRequest setBody(Object body) {
        this.body = body;
        return this;
    }
}
