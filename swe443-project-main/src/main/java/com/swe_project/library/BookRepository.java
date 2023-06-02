package com.swe_project.library;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findByIsbn(String isbn);
    Book findByOwnerID(int ownerID);
    Optional<Book> findById(Long id);
}
