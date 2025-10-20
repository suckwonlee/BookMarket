package kr.ac.Kopo.lsw.bookmarket.service;

import kr.ac.Kopo.lsw.bookmarket.domain.Order;


public interface OrderService {
    void confirmOrder(String bookId, Long quanity);
    Long saveOrder(Order order);
}
