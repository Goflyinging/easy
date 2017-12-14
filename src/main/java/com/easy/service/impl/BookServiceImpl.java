package com.easy.service.impl;


import com.easy.dao.BookMapper;
import com.easy.domain.Book;
import com.easy.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Created on 2017/11/8 <br>
 * Description: <br>
 * @author easy
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public int insert(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public Book selectById(int id) {
        return bookMapper.selectById(id);
    }

    @Override
    public int updateById(Book book) {
        return bookMapper.updateById(book);
    }

    @Override
    public int deleteById(int id) {
        return bookMapper.deleteById(id);
    }
}
