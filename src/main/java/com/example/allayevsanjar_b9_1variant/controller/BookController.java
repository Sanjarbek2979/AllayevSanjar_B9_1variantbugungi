package com.example.allayevsanjar_b9_1variant.controller;

import com.example.allayevsanjar_b9_1variant.dto.ApiResponse;
import com.example.allayevsanjar_b9_1variant.dto.BookDTO;
import com.example.allayevsanjar_b9_1variant.entity.Book;
import com.example.allayevsanjar_b9_1variant.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sanjarbek Allayev, пт 9:50. 08.04.2022
 */
@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @GetMapping
    public HttpEntity<?> getAll(){
        ApiResponse all = bookService.getAll();
        return ResponseEntity.status(all.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> get(@PathVariable Integer id){
        ApiResponse all = bookService.getOne(id);
        return ResponseEntity.status(all.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(all);
    }
    @PostMapping("/new")
    public HttpEntity<?> add(@RequestBody BookDTO dto){
        ApiResponse add = bookService.add(dto);
        return ResponseEntity.status(add.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(add);
    }
    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody BookDTO bookDTO) {
        ApiResponse edit = bookService.edit(id, bookDTO);

        return ResponseEntity.status(edit.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(edit);
    }
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {

        ApiResponse delete = bookService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(delete);
    }

}
