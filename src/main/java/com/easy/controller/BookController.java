package com.easy.controller;


import com.easy.common.bean.Result;
import com.easy.common.until.ResultUtil;
import com.easy.domain.Book;
import com.easy.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Created on 2017/11/3 <br>
 * Description: [BookController]<br>
 * @author easy
 * @version 1.0
 */
@RestController
@RequestMapping("/books")
@Api(value = "/books", description = "书籍API")
public class BookController {

  @Autowired
  BookService bookService;

  @PostMapping
  @ApiOperation(value = "新增书籍")
  @ApiImplicitParam(dataType = "Book", name = "book", value = "书籍信息", required = true)
  @ApiResponses({
      @ApiResponse(code = 201, message = "新增成功"),
      @ApiResponse(code = 500, message = "接口异常"),
  })
  public Result<Book> create(@RequestBody @Validated(Book.BookValidGroupA.class) Book book,
      BindingResult bindingResult) {
    int isSuccess = bookService.insert(book);
    if (isSuccess == 0) {
      return ResultUtil.error("插入失败", book);
    }
    return ResultUtil.success(book);
  }


}
