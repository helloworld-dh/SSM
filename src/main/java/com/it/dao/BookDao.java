package com.it.dao;

import com.it.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    public Book queryById(@Param("bookId") long id);

    public List<Book> queryAll(@Param("offset") long offset, @Param("limit") long limit);

    int deleteNumber(@Param("bookId") long id);

}
