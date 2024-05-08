package com.kobe.warehouse.easy_shop_client.http.response;

import java.util.List;

public record Pageable<T>(int totalItems, List<T> datas) {}
