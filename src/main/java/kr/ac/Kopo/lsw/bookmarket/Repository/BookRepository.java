package kr.ac.Kopo.lsw.bookmarket.Repository;

import kr.ac.Kopo.lsw.bookmarket.Domain.Book;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookByCategory(String category);
    Set<Book> getBooksByFilter(Map<String, List<String>> filter);
    void setNewBook(Book book);
}
