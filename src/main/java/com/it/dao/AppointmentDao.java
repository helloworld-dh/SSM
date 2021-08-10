package com.it.dao;

import com.it.pojo.Appointment;
import com.it.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AppointmentDao {

    public Appointment queryById(@Param("bookId") long bookId);

    public int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    public Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
