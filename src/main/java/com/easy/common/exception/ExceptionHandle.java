package com.easy.common.exception;

import com.easy.common.bean.ArgumentInvalidResult;
import com.easy.common.bean.Result;
import com.easy.common.constant.StatusConstants;
import com.easy.common.until.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * Created on 2017/10/10 <br>
 * Description: [controller异常处理]<br>
 * @author easy
 * @version 1.0
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

  private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

  /***
   * 参数校验失败异常处理
   * @param ex
   * @return
   */
  @ExceptionHandler(ValidateException.class)
  public Result handleValidateException(ValidateException ex) {
    List<ArgumentInvalidResult> errors = ex.getErrors();
    return ResultUtil.error(ex.getStatus(), "参数校验失败", errors);
  }

  /***
   * BaseException异常处理
   * @param ex
   * @return
   */
  @ExceptionHandler(BaseException.class)
  public Result baseExceptionHandler(BaseException ex) {
    logger.error(ex.getMessage(), ex);
    return ResultUtil.error(ex.getMessage(), ex.getStatus());
  }

  /***
   * 其它异常处理
   * @param ex
   * @return
   */
  @ExceptionHandler(Exception.class)
  public Result otherExceptionHandler(Exception ex) {
    logger.error(ex.getMessage(), ex);
    return ResultUtil.error(StatusConstants.EX_OTHER_CODE, ex.getMessage());
  }
}
