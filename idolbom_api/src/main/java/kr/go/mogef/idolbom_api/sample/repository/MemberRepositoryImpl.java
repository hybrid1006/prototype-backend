package kr.go.mogef.idolbom_api.sample.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.go.mogef.idolbom_api.sample.domain.Member;
import kr.go.mogef.idolbom_api.sample.domain.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Member findByLoginId(String loginId) {
        QMember member = QMember.member;
        return jpaQueryFactory.selectFrom(member).where(member.loginId.eq(loginId)).fetchOne();
    }
}
