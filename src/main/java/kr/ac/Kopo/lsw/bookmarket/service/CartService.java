package kr.ac.Kopo.lsw.bookmarket.service;

import kr.ac.Kopo.lsw.bookmarket.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
    Cart validateCart(String cartId);

}
