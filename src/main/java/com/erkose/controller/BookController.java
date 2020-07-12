package com.erkose.controller;

import com.erkose.dto.BookDto;
import com.erkose.model.Book;
import com.erkose.repository.BookRepository;
import com.erkose.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addBook")
    public List<BookDto> book(Model model, Book book){
        model.addAttribute("book",new Book());
        model.addAttribute("authorName",book.getAuthorName());
        model.addAttribute("bookName",book.getBookName());
        return bookService.getAll();
    }
    @PostMapping("/addBook")
    public List<BookDto> saveBook(@RequestBody BookDto bookDto, Model model){
        model.addAttribute("book",bookDto);
        return (List<BookDto>) bookService.save(bookDto);
    }
    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return bookRepository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
        return "delete book : " + id;
    }
}
