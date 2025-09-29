package kr.ac.Kopo.lsw.bookmarket.Service;

import kr.ac.Kopo.lsw.bookmarket.Domain.Order;


public interface OrderService {
    void confirmOrder(String bookId, Long quanity);
    Long saveOrder(Order order);
}
