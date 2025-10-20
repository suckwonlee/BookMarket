package kr.ac.Kopo.lsw.bookmarket.repository;

import kr.ac.Kopo.lsw.bookmarket.domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}
