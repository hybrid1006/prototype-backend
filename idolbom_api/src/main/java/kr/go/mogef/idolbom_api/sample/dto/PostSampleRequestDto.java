package kr.go.mogef.idolbom_api.sample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class PostSampleRequestDto {
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private String hp;
}