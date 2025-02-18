package com.konveyor;


import java.io.IOException;
import java.util.*;
import java.security.*;
import sun.misc.BASE64Encoder;
import javax.servlet.http.HttpServletResponse;

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
            MessageDigest md5Digest = MessageDigest.getInstance("MD5"); 
            byte[] hash = md5Digest.digest(input.getBytes());
            BASE64Encoder encoder = new BASE64Encoder(); 
            return encoder.encode(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}