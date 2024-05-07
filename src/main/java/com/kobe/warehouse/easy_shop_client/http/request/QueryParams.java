package com.kobe.warehouse.easy_shop_client.http.request;

import java.time.LocalDate;

public class QueryParams {
  protected LocalDate fromDate;
  protected LocalDate toDate;
  protected Long userId;
  protected int page;
  protected int size = 5;
  protected boolean withdetail;
  protected String search;
  protected String fromHour ;
  protected String toHour ;
  protected String type ;

  public String getFromHour() {
    return fromHour;
  }

  public QueryParams setFromHour(String fromHour) {
    this.fromHour = fromHour;
    return this;
  }

  public String getToHour() {
    return toHour;
  }

  public QueryParams setToHour(String toHour) {
    this.toHour = toHour;
    return this;
  }

  public int getPage() {
    return page;
  }

  public QueryParams setPage(int page) {
    this.page = page;
    return this;
  }

  public int getSize() {
    return size;
  }

  public QueryParams setSize(int size) {
    this.size = size;
    return this;
  }

  public boolean isWithdetail() {
    return withdetail;
  }

  public QueryParams setWithdetail(boolean withdetail) {
    this.withdetail = withdetail;
    return this;
  }

  public String getSearch() {
    return search;
  }

  public QueryParams setSearch(String search) {
    this.search = search;
    return this;
  }

  public String getType() {
    return type;
  }

  public QueryParams setType(String type) {
    this.type = type;
    return this;
  }

  public Long getUserId() {
    return userId;
  }

  public QueryParams setUserId(Long userId) {
    this.userId = userId;
    return this;
  }

  public LocalDate getFromDate() {
    return fromDate;
  }

  public QueryParams setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  public LocalDate getToDate() {
    return toDate;
  }

  public QueryParams setToDate(LocalDate toDate) {
    this.toDate = toDate;
    return this;
  }
}
