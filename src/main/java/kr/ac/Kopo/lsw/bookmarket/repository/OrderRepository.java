package kr.ac.Kopo.lsw.bookmarket.repository;

import kr.ac.Kopo.lsw.bookmarket.domain.Order;

public interface OrderRepository {
//    주문목록 저장
    Long saveOrder(Order order);
}
