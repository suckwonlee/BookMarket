package kr.ac.Kopo.lsw.bookmarket.Service;

import kr.ac.Kopo.lsw.bookmarket.Domain.Book;
import kr.ac.Kopo.lsw.bookmarket.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }
    @Override
    public Book getBookById(String bookId) {
        Book book = bookRepository.getBookById(bookId);
        return book;
    }

    @Override
    public List<Book> getBookByCategory(String category) {
        List<Book> booksByCategory = bookRepository.getBookByCategory(category);
        return booksByCategory;
    }

    @Override
    public Set<Book> getListByFillter(Map<String, List<String>> filter) {
        Set<Book> booksByFilter=bookRepository.getBooksByFilter(filter);
        return booksByFilter;
    }
}
