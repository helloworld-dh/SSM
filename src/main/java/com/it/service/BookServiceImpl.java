package com.it.service;

import com.it.dao.BookDao;
import com.it.pojo.Book;

public class BookServiceImpl implements BookService{

    BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book queryById(int id) {

        Book book = bookDao.queryById(id);
        return book;
    }
}
