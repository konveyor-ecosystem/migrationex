package com.konveyor;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryServlet extends HttpServlet {
  private static final long serialVersionUID = 1 L;
  private Library library = new Library();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title = request.getParameter("title");
    response.setContentType("text/plain");

    if (title != null) {
      Optional < Book > book = library.findBookByTitle(title);
      if (book.isPresent()) {
        response.getWriter().println(book.get());
      } else {
        response.getWriter().println("Book not found: " + title);
      }
    } else {
      library.printBooks(response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title = request.getParameter("title");
    String author = request.getParameter("author");

    if (title != null && author != null) {
      library.addBook(new Book(title, author));
      response.getWriter().println("Book added successfully: " + title + " by " + author);
    } else {
      response.getWriter().println("Missing title or author");
    }
  }

  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title = request.getParameter("title");

    if (title != null) {
      Optional < Book > book = library.findBookByTitle(title);
      if (book.isPresent()) {
        library.removeBook(book.get());
        response.getWriter().println("Book deleted successfully: " + title);
      } else {
        response.getWriter().println("Book not found: " + title);
      }
    } else {
      response.getWriter().println("Missing title parameter.");
    }
  }
}