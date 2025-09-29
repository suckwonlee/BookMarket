package kr.ac.Kopo.lsw.bookmarket.Service;

import kr.ac.Kopo.lsw.bookmarket.Domain.Book;
import kr.ac.Kopo.lsw.bookmarket.Domain.Order;
import kr.ac.Kopo.lsw.bookmarket.Repository.BookRepository;
import kr.ac.Kopo.lsw.bookmarket.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void confirmOrder(String bookId, Long quanity) {
            Book bookByid=bookRepository.getBookById(bookId);
            if(bookByid.getUnitsInStock()<quanity){
                throw new IllegalArgumentException("재고가 부족합니다. 구입 가능한 도서 수량: " + bookByid.getUnitsInStock());
            }
            bookByid.setUnitsInStock(bookByid.getUnitsInStock()+quanity);
        }

    @Override
    public Long saveOrder(Order order){
            Long orderId=orderRepository.saveOrder(order);
            return orderId;
    }
}
