package kr.go.mogef.idolbom_api.sample.mapper;

import kr.go.mogef.idolbom_api.sample.dto.GetSampleResponseDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
    GetSampleResponseDto selectMember(String loginId);
}
