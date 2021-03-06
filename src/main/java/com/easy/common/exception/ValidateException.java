package com.easy.common.exception;


import com.easy.common.bean.ArgumentInvalidResult;
import java.util.List;

/***
 * Created on 2017/11/1 <br>
 * Description: [参数校验失败异常]<br>
 * @author easy
 * @version 1.0
 */
public class ValidateException extends BaseException {

  private List<ArgumentInvalidResult> errors;

  public ValidateException(int status, List<ArgumentInvalidResult> errors) {
    super.setStatus(status);
    this.errors = errors;
  }

  public List<ArgumentInvalidResult> getErrors() {
    return errors;
  }

  public void setErrors(List<ArgumentInvalidResult> errors) {
    this.errors = errors;
  }

}

