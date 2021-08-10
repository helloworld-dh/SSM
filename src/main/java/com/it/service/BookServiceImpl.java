package com.it.service;

import com.it.dao.BookDao;
import com.it.pojo.Book;

import java.util.List;

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

    @Override
    public List<Book> queryAll(int offset, int limit) {
        List<Book> books = bookDao.queryAll(offset, limit);
        return books;
    }

    @Override
    public int deleteNumber(int id) {
        int i = bookDao.deleteNumber(id);
        return i;
    }
}
