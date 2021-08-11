import com.it.dao.AppointmentDao;
import com.it.dao.BookDao;
import com.it.dto.AppointExecution;
import com.it.pojo.Appointment;
import com.it.pojo.Book;
import com.it.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
/*
* 配置spring和junit的整合，junit启动时加载springIOC容器
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class MyTest {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    @Autowired
    private BookService bookService;

    @Test
    public void testQueryById(){
        long bookId=1000;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }
    @Test
    public void testQueryAll(){
        List<Book> books = bookDao.queryAll(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber(){
        long bookId = 1000;
        int update = bookDao.reduceNumber(bookId);
        System.out.println(update);
    }

    @Test
    public void testInsertAppointment(){
        long bookId = 1000;
        long studentId = 12345;
        int insert = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println("insert"+insert);
    }

    @Test
    public void testQueryByKeyWithBook(){
        long bookId = 1000;
        long studentId = 1;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }

    @Test
    public void testAppoint(){
        long bookId =1002;
        long studentId = 2;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }

    @Test
    public void testUpdateBook(){
        Book book = new Book(1005,"操作系统",14);
        int update = bookService.updateBook(book);
        System.out.println(update);
    }

}
