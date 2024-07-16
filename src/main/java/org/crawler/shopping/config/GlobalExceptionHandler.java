package org.crawler.shopping.config;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.crawler.shopping.utils.Result;
import org.crawler.shopping.utils.ResultCode;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(BindException.class)
  public Object bindException(BindException e) {
    System.out.println("bindException: ===================="+ ExceptionUtils.getStackTrace(e));
    return Result.error();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Result bindException(MethodArgumentNotValidException e) {
    System.out.println("MethodArgumentNotValidException");
    System.out.println("*********************************************************");
    System.out.println(ExceptionUtils.getStackTrace(e));
    return Result.error(ResultCode.PASSWORD_COMPLEX_ERROR,e.getBindingResult().getFieldError().getDefaultMessage());
  }

  @ExceptionHandler(NullPointerException.class)
  public Object NullPointerExceptionHandler(NullPointerException e, HttpServletRequest req) {
    System.out.println("NullPointerException");
    System.out.println(ExceptionUtils.getStackTrace(e));
    return Result.error();
  }

  @ExceptionHandler(Exception.class)
  public Object handleException(Exception e, HttpServletRequest req) {
    System.out.println("handleException");
    System.out.println(ExceptionUtils.getStackTrace(e));
    return Result.error();
  }
}
