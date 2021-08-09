package com.it.dao;

import com.it.pojo.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {

    public int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    public Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
