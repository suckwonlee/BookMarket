package kr.ac.Kopo.lsw.bookmarket.Repository;

import kr.ac.Kopo.lsw.bookmarket.Domain.Order;
import org.aspectj.weaver.ast.Or;
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
