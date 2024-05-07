package com.kobe.warehouse.easy_shop_client.http.error;

import java.util.ArrayList;
import java.util.List;

public class RemoteException extends RuntimeException {
    private String type;
    private String title;
    private Integer status;
    private String detail;
    private String message;
    private String path;
    private List<FieldError> fieldErrors=new ArrayList<>();

    public String getType() {
        return type;
    }

    public RemoteException setType(String type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RemoteException setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public RemoteException setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public RemoteException setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public RemoteException() {
    }

    public String getMessage() {
        return message;
    }

    public RemoteException setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public RemoteException setPath(String path) {
        this.path = path;
        return this;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public RemoteException setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
        return this;
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", detail='" + detail + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", fieldErrors=" + fieldErrors +
                '}';
    }
}
