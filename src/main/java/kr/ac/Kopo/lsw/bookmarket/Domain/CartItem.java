package kr.ac.Kopo.lsw.bookmarket.Domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class CartItem {
    private Book book;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(Book book){
        this.book = book;
        quantity = 1;
        totalPrice = book.getUnitPrice();
    }

    public void setBook(Book book){
        this.book = book;
        updateTotalPrice();
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
        updateTotalPrice();
    }

    public void updateTotalPrice(){
        totalPrice = this.book.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }

}
