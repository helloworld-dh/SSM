package com.it.service;

import com.it.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    public Book queryById(int id);

    public List<Book> queryAll(int offset, int limit);

    int deleteNumber(int id);
}
