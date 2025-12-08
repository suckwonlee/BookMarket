package kr.ac.Kopo.lsw.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.ac.Kopo.lsw.bookmarket.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberId(String memberId);
}
