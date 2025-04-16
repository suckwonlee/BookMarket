package kr.ac.Kopo.lsw.bookmarket.Service;

import kr.ac.Kopo.lsw.bookmarket.Domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookByCategory(String category);
}
