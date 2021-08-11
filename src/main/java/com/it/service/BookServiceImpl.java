package com.it.service;

import com.it.dao.AppointmentDao;
import com.it.dao.BookDao;
import com.it.dto.AppointExecution;
import com.it.enums.AppointStateEnum;
import com.it.exception.AppointException;
import com.it.exception.NoNumberException;
import com.it.exception.RepeatAppointException;
import com.it.pojo.Appointment;
import com.it.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Book queryById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> queryAll() {
        return bookDao.queryAll(0,1000);
    }

    @Override
    @Transactional
    public AppointExecution appoint(long bookId, long studentId) {

        try {
            //减库存
            int delete = bookDao.reduceNumber(bookId);
            if (delete<0){
                //库存不足
                throw new NoNumberException("no number");
            }else {
                //执行预约操作
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert<=0){
                    //重复预约
                    throw new RepeatAppointException("repeat appoint");
                }else {
                    //预约成功
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        } catch (NoNumberException e1) {
            throw e1;
        } catch (RepeatAppointException e2){
            throw e2;
        }catch (Exception e){
            throw new AppointException("appoint inner error:" +e.getMessage());
        }
    }

    @Override
    public Book queryBookByName(String bookName) {
        Book book = bookDao.queryBookByName(bookName);
        return book;
    }

    @Override
    public int updateBook(Book book) {
        int update = bookDao.updateBook(book);
        return update;
    }

    @Override
    public int addBook(Book book) {
        int add = bookDao.addBook(book);
        return add;
    }

    @Override
    public int deleteBookById(int bookId) {
        int delete = bookDao.deleteBookById(bookId);
        return delete;
    }
}
