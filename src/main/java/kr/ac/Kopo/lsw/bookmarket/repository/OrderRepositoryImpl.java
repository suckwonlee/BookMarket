package kr.ac.Kopo.lsw.bookmarket.repository;

import kr.ac.Kopo.lsw.bookmarket.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private Map<Long, Order> listofOrders;
    private long nextOrderId;

    public OrderRepositoryImpl() {
        listofOrders=new HashMap<>();
        nextOrderId=2000;
    }

    @Override
    public Long saveOrder(Order order){
        order.setOrderId(getnextOrderId());
        listofOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }

    private synchronized Long getnextOrderId(){
        return nextOrderId++;
    }
}
