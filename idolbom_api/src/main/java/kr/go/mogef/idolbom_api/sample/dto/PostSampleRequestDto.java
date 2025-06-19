package kr.go.mogef.idolbom_api.sample.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostSampleRequestDto {
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private String hp;
}