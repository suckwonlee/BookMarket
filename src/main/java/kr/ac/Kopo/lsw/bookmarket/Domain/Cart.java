package kr.ac.Kopo.lsw.bookmarket.Domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class Cart {
    private String CartId;
    private Map<String, CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart(){
        cartItems = new HashMap<>();
        grandTotal = new BigDecimal(0);
    }

    public Cart(String cartId){
        this();
        this.CartId=cartId;
    }
    public void addCartItem(CartItem item) {
        String bookId = item.getBook().getBookId();

        if (cartItems.containsKey(bookId)) {
            CartItem cartItem = cartItems.get(bookId);
            cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
            cartItems.put(bookId, cartItem);
        } else {
            cartItems.put(bookId, item);
        }

        updateGrandTotal();
    }
    public void updateGrandTotal() {
        grandTotal=new BigDecimal(0);
        for (CartItem cartItem : cartItems.values()) {
            grandTotal=grandTotal.add(cartItem.getTotalPrice());
        }
    }

}
