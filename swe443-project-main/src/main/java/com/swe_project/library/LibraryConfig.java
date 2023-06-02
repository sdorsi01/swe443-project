package com.swe_project.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {

    @Bean
    public Library library() {
        return new Library();
    }
}

