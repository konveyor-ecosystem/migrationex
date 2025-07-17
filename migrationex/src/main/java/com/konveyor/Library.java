package com.konveyor;


import java.io.IOException;
import java.util.*;
import java.security.*;
import java.util.Base64;
import jakarta.servlet.http.HttpServletResponse;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public Library() {
        addBook(new Book("Effective Java", "Joshua Bloch"));
        addBook(new Book("Java Concurrency in Practice", "Brian Goetz"));
    }

    public void addBook(Book book) {
        String hash = generateHash(book.getTitle());
        books.put(hash, book);
    }

    public void removeBook(Book book) {
        String hash = generateHash(book.getTitle());
        books.remove(hash);
    }

    public Optional<Book> findBookByTitle(String title) {
        String hash = generateHash(title);
        return Optional.ofNullable(books.get(hash));
    }

    public void printBooks(HttpServletResponse response) throws IOException {
        for (Book book : books.values()) {
            response.getWriter().println(book);
        }
    }


    private String generateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
            byte[] hash = digest.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}