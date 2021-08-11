package com.it.dao;

import com.it.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    public Book queryById(@Param("bookId") long id);

    public List<Book> queryAll(@Param("offset") long offset, @Param("limit") long limit);

    public int reduceNumber(@Param("bookId") long id);

    public Book queryBookByName(@Param("bookName") String bookName);

    public int updateBook(Book book);

    public int addBook(Book book);

    public int deleteBookById(@Param("bookId") int id);

}
