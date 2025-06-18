package kr.ac.Kopo.lsw.bookmarket.Service;

import kr.ac.Kopo.lsw.bookmarket.Domain.Cart;
import kr.ac.Kopo.lsw.bookmarket.Repository.CartRepository;
import kr.ac.Kopo.lsw.bookmarket.Repository.CartRepositoryImpl;
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


}
