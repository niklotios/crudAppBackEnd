package com.example.crud.category;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    public List<Category> getStudents() {
        return List.of(
                new Category(
                        1L,
                        "χαρτικά"
                )
        );
    }

}
