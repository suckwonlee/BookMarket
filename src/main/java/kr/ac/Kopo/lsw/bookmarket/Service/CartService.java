package kr.ac.Kopo.lsw.bookmarket.Service;

import kr.ac.Kopo.lsw.bookmarket.Domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);

}
