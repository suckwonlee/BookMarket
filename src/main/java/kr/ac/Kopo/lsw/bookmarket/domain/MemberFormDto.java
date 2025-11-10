package kr.ac.Kopo.lsw.bookmarket.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDto {

    @NotBlank(message = "아이디는 필수 입력 항목입니다.")
    private String memberId;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Length(min=8,max=16, message = "비밀번호는 최소 8자리 이상 16자리 이하로 작성해주세요")
    private String password;

    @NotBlank(message = "성명은 필수 입력 항목입니다.")
    private String name;

    @NotBlank(message = "전화번호는 필수 입력 항목입니다.")
    private String phone;

    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Email(message = "이메일 형식이 잘못되었습니다.")
    private String email;

    @NotBlank(message = "주소는 필수 입력 항목입니다.")
    private String address;
}
