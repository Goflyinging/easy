package com.easy.common.bean;

/***
 * Created on 2017/11/1 <br>
 * Description: [参数校验失败返回信息]<br>
 * @author easy
 * @version 1.0
 */
public class ArgumentInvalidResult {

  /**
   * 字段名
   */
  private String field;
  /**
   * 字段值
   */
  private Object rejectedValue;
  /**
   * 校验失败信息
   */
  private String defaultMessage;

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public Object getRejectedValue() {
    return rejectedValue;
  }

  public void setRejectedValue(Object rejectedValue) {
    this.rejectedValue = rejectedValue;
  }

  public String getDefaultMessage() {
    return defaultMessage;
  }

  public void setDefaultMessage(String defaultMessage) {
    this.defaultMessage = defaultMessage;
  }
}
