package com.easy.common.until;

import com.easy.common.bean.Result;

/***
 * Created on 2017/12/14 <br>
 * Description: [返回参数结果封装]<br>
 * @author easy
 * @version 1.0
 */
public class ResultUtil {

  /**
   * 正常返回
   *
   * @param obj 返回实体
   * @param <T> 泛型类型
   * @return 泛型类型
   */
  public static <T> Result<T> success(T obj) {
    Result<T> result = new Result<>();
    result.setSuccess(true);
    result.setObj(obj);
    return result;
  }

  /**
   * 异常返回
   *
   * @param status 状态码
   * @param message 信息
   * @param <T> 泛型类型
   * @return 泛型类型
   */
  public static <T> Result<T> error(int status, String message) {
    Result<T> result = new Result<>();
    result.setMessage(message);
    result.setStatus(status);
    return result;
  }

  public static <T> Result<T> error(int status, T obj) {
    Result<T> result = new Result<>();
    result.setStatus(status);
    result.setObj(obj);
    return result;
  }

  public static <T> Result<T> error(int status, String messsage, T obj) {
    Result<T> result = new Result<>();
    result.setStatus(status);
    result.setMessage(messsage);
    result.setObj(obj);
    return result;
  }

  public static <T> Result<T> error(String messsage, T obj) {
    Result<T> result = new Result<>();
    result.setMessage(messsage);
    result.setObj(obj);
    return result;
  }

}
