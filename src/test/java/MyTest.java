import com.it.pojo.Book;
import com.it.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService)context.getBean("BookServiceImpl");
        Book book = bookServiceImpl.queryById(1000);
        List<Book> books = bookServiceImpl.queryAll(1, 2);
        int i = bookServiceImpl.deleteNumber(1004);
        System.out.println(book);
        System.out.println(books);
    }
}
