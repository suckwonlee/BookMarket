package kr.ac.Kopo.lsw.bookmarket.repository;

import kr.ac.Kopo.lsw.bookmarket.domain.Cart;

public interface CartRepository {

	Cart create(Cart cart);
	
	Cart read(String cartId);
	
	void update(String cartId, Cart cart);

	void delete(String cartId);
}
