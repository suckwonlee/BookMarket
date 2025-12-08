package kr.ac.Kopo.lsw.bookmarket.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import kr.ac.Kopo.lsw.bookmarket.domain.Book;

public interface BookRepository {

	List<Book> getAllBookList();
	List<Book> getBookListByCategory(String category); 
	Set<Book> getBookListByFilter(Map<String, List<String>> filter); 
	Book getBookById(String bookId);
	void setNewBook(Book book);
	void setUpdateBook(Book book);
	void setDeleteBook(String bookID);
}
