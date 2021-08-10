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

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    private String list(Model model){
        List<Book> books = bookService.queryAll();
        model.addAttribute("books",books);
        return "list";
    }

    @GetMapping("/{bookId}/detail")
    private String detail(@PathVariable("bookId") Long bookId, Model model){
        if (bookId==null){
            return "redirect:/book/list";
        }
        Book book = bookService.queryById(bookId);
        if (book == null){
            return "forward:/book/list";
        }
        model.addAttribute("book",book);
        return "detail";
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
