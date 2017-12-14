package com.easy.service;


import com.easy.domain.Book;

/***
 * Created on 2017/11/8 <br>
 * Description: <br>
 * @author easy
 */
public interface BookService {
    int insert(Book book);

    Book selectById(int id);

    int updateById(Book book);

    int deleteById(int id);
}
