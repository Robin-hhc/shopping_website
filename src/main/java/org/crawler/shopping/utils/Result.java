package org.crawler.shopping.utils;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Result {

  private Boolean success;
  private Integer code;
  private String message;
  private Map<String, Object> data = new HashMap<String, Object>();
  private Result() {}

  public static Result ok() {
    Result r = new Result();
    r.setSuccess(true);
    r.setCode(ResultCode.SUCCESS);
    r.setMessage("Success.");
    return r;
  }

  public static Result error() {
    Result r = new Result();
    r.setSuccess(false);
    r.setCode(ResultCode.ERROR);
    r.setMessage("Error.");
    return r;
  }

  public static Result error(Integer code, String msg) {
    Result r = new Result();
    r.setSuccess(false);
    r.setCode(code);
    r.setMessage(msg);
    return r;
  }

  public Result success(Boolean success){
    this.setSuccess(success);
    return this;
  }

  public Result message(String message){
    this.setMessage(message);
    return this;
  }

  public Result code(Integer code){
    this.setCode(code);
    return this;
  }

  public Result data(String key, Object value){
    this.data.put(key, value);
    return this;
  }

  public Result data(Map<String, Object> map){
    this.setData(map);
    return this;
  }
}
