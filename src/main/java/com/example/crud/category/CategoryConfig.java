package com.example.crud.category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository repository){
        return args ->{
             Category xartika = new Category (
                    "χαρτικά"
            );

             Category trofima_psygeiou = new Category (
                    "τρόφιμα ψυγείου"
            );

             repository.saveAll(List.of(xartika,trofima_psygeiou));
        };
    }
}
