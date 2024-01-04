package com.example.crud.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository
        extends JpaRepository<Category, Long> {

    Optional<Category> findCategoriesByCategoryName(String categoryName);

    Optional<Category> findByCategoryName(String categoryName);
}
