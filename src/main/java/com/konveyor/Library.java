package com.konveyor;

import java.io.IOException;
import java.util.*;
import java.security.*;
import java.util.Base64; // Updated import for Base64
import jakarta.servlet.http.HttpServletResponse; // Updated import for Jakarta EE

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
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256"); // Updated to SHA-256
            byte[] hash = sha256Digest.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(hash); // Updated to use Base64 from java.util
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}