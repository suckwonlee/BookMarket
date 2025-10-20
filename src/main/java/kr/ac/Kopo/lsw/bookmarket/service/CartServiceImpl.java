package kr.ac.Kopo.lsw.bookmarket.service;

import kr.ac.Kopo.lsw.bookmarket.domain.Cart;
import kr.ac.Kopo.lsw.bookmarket.repository.CartRepository;
import kr.ac.Kopo.lsw.bookmarket.repository.CartRepositoryImpl;
import kr.ac.Kopo.lsw.bookmarket.exception.CartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository CartRepository;
    @Autowired
    private CartRepositoryImpl cartRepositoryImpl;


    @Override
    public Cart create(Cart cart) {

        return CartRepository.create(cart);
    }
    @Override
    public Cart read(String cartId) {
        return CartRepository.read(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        CartRepository.update(cartId, cart);
    }

    @Override
    public void delete(String cartId) {
        CartRepository.delete(cartId);
    }

    @Override
    public Cart validateCart(String cartId) {
        Cart cart=CartRepository.read(cartId);
        if(cart==null || cart.getCartItems().size()==0){
            throw new CartException(cartId);
        }

        return cart;
    }


}
