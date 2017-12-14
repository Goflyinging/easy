package com.easy.common.bean;

import java.io.Serializable;

/***
 * Created on 2017/12/14 <br>
 * Description: []<br>
 * @author easy
 * @version 1.0
 */
public class Result<T> implements Serializable {

  private boolean success = false;
  private int status;
  private String message;
  private T obj;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getObj() {
    return obj;
  }

  public void setObj(T obj) {
    this.obj = obj;
  }
}
