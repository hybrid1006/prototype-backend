package kr.go.mogef.idolbom_api.sample.repository;

import kr.go.mogef.idolbom_api.sample.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

  Member findByLoginId(String loginId);
  void deleteByLoginId(String loginId);

}