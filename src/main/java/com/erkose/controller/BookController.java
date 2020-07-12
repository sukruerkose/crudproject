package com.erkose.controller;

import com.erkose.model.Book;
import com.erkose.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    public BookController() {
    }

    @GetMapping("/addBook")
    public String book(Model model){
        model.addAttribute("book",new Book());
        return "book";
    }
    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book,Model model){
        model.addAttribute("book",book);
        bookRepository.save(book);
        return "Added book with id : " + book.getId();
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
