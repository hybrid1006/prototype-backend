package kr.go.mogef.idolbom_api.sample.repository;

import kr.go.mogef.idolbom_api.sample.domain.Member;
import kr.go.mogef.idolbom_api.sample.dto.GetSampleRequestDto;

public interface MemberRepositoryCustom {
    Member findByLoginId(String loginId);
}
