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
}
