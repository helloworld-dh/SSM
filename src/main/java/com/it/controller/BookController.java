package com.it.controller;

import com.it.dto.AppointExecution;
import com.it.dto.Result;
import com.it.enums.AppointStateEnum;
import com.it.exception.NoNumberException;
import com.it.exception.RepeatAppointException;
import com.it.pojo.Book;
import com.it.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/allBook")
    private String list(Model model){
        List<Book> books = bookService.queryAll();
        for (Book book : books) {
            System.out.println(book);
        }
        model.addAttribute("books",books);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Book book = bookService.queryById(id);
        model.addAttribute("Book",book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Book book){
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        Book book = bookService.queryBookByName(queryBookName);
        List<Book> list = new ArrayList<>();
        list.add(book);
        if(book==null){
            list=bookService.queryAll();
            model.addAttribute("error","没查到");
        }
        model.addAttribute("books",list);
        return "allBook";
    }

    @PostMapping(value = "/{bookId}/appoint", produces = {"application/json; charset=utf-8"})
    @ResponseBody
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId){
        if (studentId==null || studentId.equals("")){
             return new Result<>(false, "学号不能为空");
        }
        AppointExecution execution = null;
        try{
            execution = bookService.appoint(bookId, studentId);
        }catch (NoNumberException e1){
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        }catch (RepeatAppointException e2){
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        }catch (Exception e){
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true, execution);
    }
}
