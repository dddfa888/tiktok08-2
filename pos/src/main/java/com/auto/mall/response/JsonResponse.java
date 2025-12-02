 

package com.auto.mall.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JsonResponse<T> {
  private T data;
  private int code;
  private boolean success;
  private String msg;

  public static JsonResponse success() {
    return new JsonResponse();
  }

  private JsonResponse() {
    this(200, "", true);
  }

  public static JsonResponse success(int code, String message) {
    return new JsonResponse(code, message, true);
  }

  public static <T> JsonResponse success(int code, String message, T data) {
    return new JsonResponse(code, message, true, data);
  }

  public static JsonResponse fail(String message) {
    return new JsonResponse(500, message, false);
  }

  public static JsonResponse fail(int code, String message) {
    return new JsonResponse(code, message, false);
  }

  private JsonResponse(int code, String message, boolean success) {
    this(code, message, success, (T) null);
  }

  private JsonResponse(int code, String message, boolean success, T data) {
    this.code = code;
    this.msg = message;
    this.success = success;
    this.data = data;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public int getCode() {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
