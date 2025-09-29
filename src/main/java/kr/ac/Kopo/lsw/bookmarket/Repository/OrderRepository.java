package kr.ac.Kopo.lsw.bookmarket.Repository;

import kr.ac.Kopo.lsw.bookmarket.Domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}
