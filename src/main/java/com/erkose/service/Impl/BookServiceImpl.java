package com.erkose.service.Impl;

import com.erkose.dto.BookDto;
import com.erkose.model.Book;
import com.erkose.repository.BookRepository;
import com.erkose.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Autowired
    private final BookRepository bookRepository;


    @Transactional
    @Override
    public BookDto save(BookDto bookDto) {
        //Assert.isNull(kisiDto.getAdi(),"Adi alanı zorunludur.");
        // if (!kisiDto.getAdi().isEmpty()) {
        Book book = new Book();
        book.setAuthorName(bookDto.getAuthorName());
        book.setBookName(bookDto.getBookName());
        final Book bookDb = bookRepository.save(book);

        bookDto.setId(bookDb.getId());
        // }
        return bookDto;
    }
    @Override
    public List<BookDto> getAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        books.forEach(it -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(it.getId());
            bookDto.setAuthorName(it.getAuthorName());
            bookDto.setBookName(it.getBookName());
            bookDtos.add(bookDto);
        });
        return bookDtos;
    }
    @Override
    public void delete(Long id) {

    }
    @Override
    public Page<BookDto> getAll(Pageable pageable) {
        return null;
    }

}
