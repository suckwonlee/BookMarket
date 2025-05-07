package kr.ac.Kopo.lsw.bookmarket.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
//@Getter
//@Setter
//@NoArgsConstructor
public class Book {
    private String bookId;//도서번호
    private String Name;//도서명
    private String author;//작가
    private BigDecimal unitPrice;//단가
    private String Description;//도서설명
    private String publisher;//출판사
    private String Category;//도서분류
    private long unitsInStock;//재고량
    private String condition;//신규도서 or 중고도서 or 전자책
    private String releaseDate;//출판일
    private String filename;//도서 이미지 파일명
    private MultipartFile bookImage;//업로드된 도서 이미지 파일


}
