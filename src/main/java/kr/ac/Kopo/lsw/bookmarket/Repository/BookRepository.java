package kr.ac.Kopo.lsw.bookmarket.Repository;

import kr.ac.Kopo.lsw.bookmarket.Domain.Book;
import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList();
}
