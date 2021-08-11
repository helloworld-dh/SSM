package com.it.service;

import com.it.dto.AppointExecution;
import com.it.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    /*
    * 查询一本书
    * */
    public Book queryById(long bookId);

    /*
    * 查询所有书
    * */
    public List<Book> queryAll();

    /*
    * 预约书
    * */
    public AppointExecution appoint(long bookId, long studentId);

    /*
    * 通过书名查询书
    * */
    public Book queryBookByName(String bookName);

    /*
    * 更新书
    * */
    public int updateBook(Book book);

    /*
    * 添加一本书
    * */
    public int addBook(Book book);

    /*
    * 通过ID删除一本书
    * */
    public int deleteBookById(int bookId);

}
