package kr.go.mogef.idolbom_api.sample.service;

import kr.go.mogef.idolbom_api.sample.dto.PostSampleRequestDto;
import kr.go.mogef.idolbom_api.sample.dto.PostSampleResponseDto;
import kr.go.mogef.idolbom_api.sample.exception.SampleException;
import kr.go.mogef.idolbom_api.sample.domain.Member;
import kr.go.mogef.idolbom_api.sample.dto.GetSampleRequestDto;
import kr.go.mogef.idolbom_api.sample.dto.GetSampleResponseDto;
import kr.go.mogef.idolbom_api.sample.exception.SampleError;

import kr.go.mogef.idolbom_api.sample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final MemberRepository memberRepository;

    public GetSampleResponseDto getMemberInfo(String loginId) {
        Member member = Optional.ofNullable(memberRepository.findByLoginId(loginId)).orElseThrow(() -> new SampleException(SampleError.USER_NOT_FOUND));

        return GetSampleResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .loginId(member.getLoginId())
                .build();
    }

    public GetSampleResponseDto getMemberQuerydsl(GetSampleRequestDto dto) {
        Member member = Optional.ofNullable(memberRepository.findByLoginId(dto.getLoginId())).orElseThrow(() -> new SampleException(SampleError.USER_NOT_FOUND));

        return GetSampleResponseDto
                .builder()
                .id(member.getId())
                .name(member.getName())
                .loginId(member.getLoginId())
                .hp(member.getHp())
                .build();
    }

    @Transactional
    public PostSampleResponseDto save(PostSampleRequestDto dto) {
        Optional<Member> opt = Optional.ofNullable(memberRepository.findByLoginId(dto.getLoginId()));
        Member memberEntity = new Member();
        opt.ifPresentOrElse(
                member -> {
                    member.setHp(Optional.ofNullable(dto.getHp()).orElse(member.getHp()));
                    memberEntity.setId(member.getId());
                },
                () -> {
                    memberEntity.setName(dto.getName());
                    memberEntity.setLoginId(dto.getLoginId());
                    memberEntity.setPassword(dto.getPassword());
                    memberEntity.setHp(dto.getHp());
                    memberRepository.save(memberEntity);
                }
                );
        return PostSampleResponseDto.builder().id(memberEntity.getId()).build();
    }


}
