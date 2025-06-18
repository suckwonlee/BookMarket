package kr.ac.Kopo.lsw.bookmarket.Repository;

import kr.ac.Kopo.lsw.bookmarket.Domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
