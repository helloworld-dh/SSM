package com.it.dao;

import com.it.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    public Book queryById(@Param("bookId") int id);

    public List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int deleteNumber(int id);

}
