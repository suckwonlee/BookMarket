package kr.ac.Kopo.lsw.bookmarket.service;

import jakarta.transaction.Transactional;
import kr.ac.Kopo.lsw.bookmarket.domain.Member;
import kr.ac.Kopo.lsw.bookmarket.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
  private final MemberRepository memberRepository;

  //회원 정보 저장
  public Member saveMember(Member member) {
      validateDuplicateMember(member);
      return memberRepository.save(member);
  }

  //특정 멤버ID를 가진 멤버 엔티티 반환
  public Member getMemberByMemberId(String memberId) {
      return memberRepository.findByMemberId(memberId);
  }

  //멤버 엔티티를 삭제
  public void deleteMember(String memberId) {
      Member member = getMemberByMemberId(memberId);
      memberRepository.deleteById(member.getNum());
  }

  private void validateDuplicateMember(Member member) {
      Member findMember=memberRepository.findByMemberId(member.getMemberId());
      if(findMember!=null) {
          throw new IllegalStateException("Duplicate member found");

      }
  }

  @Override
  public UserDetails loadUserByUsername(String memberid)  throws UsernameNotFoundException{
      Member member = memberRepository.findByMemberId(memberid);
      if(member==null) {
          throw new UsernameNotFoundException("user not found");
      }
      UserDetails userDetails= User.builder()
              .username(member.getMemberId())
              .password(member.getPassword())
              .roles(member.getRole().toString())
              .build();
              return userDetails;
  }
}
