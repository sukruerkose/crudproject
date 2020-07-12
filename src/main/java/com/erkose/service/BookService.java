package com.erkose.service;

import com.erkose.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookDto save(BookDto kisiDto);

    List<BookDto> getAll();

    void delete(Long id);

    Page<BookDto> getAll(Pageable pageable);
}
