package kr.go.mogef.idolbom_api.sample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetSampleResponseDto {
    private Long id;
    private String loginId;
    private String name;
    private String hp;
    private String address;

}