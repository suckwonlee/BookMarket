package kr.ac.Kopo.lsw.bookmarket.Repository;

import kr.ac.Kopo.lsw.bookmarket.Domain.Book;
import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookByCategory(String category);


}
