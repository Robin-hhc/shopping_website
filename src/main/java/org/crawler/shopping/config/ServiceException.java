package org.crawler.shopping.config;

public class ServiceException extends RuntimeException{
    private String code;
    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
