package kr.ac.Kopo.lsw.bookmarket.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String country;
    private String zipCode;
    private String addressName;
    private String detailName;
}
