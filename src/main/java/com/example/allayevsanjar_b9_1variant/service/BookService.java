package com.example.allayevsanjar_b9_1variant.service;

import com.example.allayevsanjar_b9_1variant.dto.ApiResponse;
import com.example.allayevsanjar_b9_1variant.dto.BookDTO;
import com.example.allayevsanjar_b9_1variant.entity.Book;
import com.example.allayevsanjar_b9_1variant.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, пт 9:52. 08.04.2022
 */
@Service
@RequiredArgsConstructor
public class BookService {
final BookRepository bookRepository;

    public ApiResponse getAll() {
        return new ApiResponse("Mana",true , bookRepository.findAll());
    }

    public ApiResponse getOne(Integer id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Xatolik",false);
        }
        return new ApiResponse("Mana",true,byId.get());
    }
    public ApiResponse add(BookDTO bookDTO) {
        Book book= new Book();
        book.setCategory(bookDTO.getCategory());
        book.setName(bookDTO.getName());
        book.setPrice(bookDTO.getPrice());

        Book save = bookRepository.save(book);
        return new ApiResponse("Qo`shildi",true,save);
    }


    public ApiResponse edit(Integer id,BookDTO bookDTO) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isEmpty()){
            return new ApiResponse("Xatolik",false);
        }
        Book book = byId.get();
        book.setCategory(bookDTO.getCategory());
        book.setName(bookDTO.getName());
        book.setPrice(bookDTO.getPrice());

        Book save = bookRepository.save(book);
        return new ApiResponse("Tahrirlandi",true,save);
    }


    public ApiResponse delete(Integer id) {

        bookRepository.deleteById(id);
        return new ApiResponse("O`chirildi",true);
    }

}
