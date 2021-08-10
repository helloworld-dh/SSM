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
            int delete = bookDao.deleteNumber(bookId);
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
}
