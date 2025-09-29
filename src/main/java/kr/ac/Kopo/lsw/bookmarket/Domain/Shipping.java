package kr.ac.Kopo.lsw.bookmarket.Domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private String date;
    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;

}
