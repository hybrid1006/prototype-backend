package kr.go.mogef.idolbom_api.sample;

import kr.go.mogef.idolbom_api.sample.dto.GetSampleResponseDto;
import kr.go.mogef.idolbom_api.sample.exception.SampleException;
import kr.go.mogef.idolbom_api.sample.service.SampleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SampleTest {

    @Autowired
    private SampleService sampleService;

    @Test
    @DisplayName("회원명 찾기 ")
    void findMemberName() {
        //given
        String loginId = "admin1";
        //when
        GetSampleResponseDto responseDto = sampleService.getMemberInfo(loginId);
        //then
        assertEquals("테스트1", responseDto.getName());
    }

    @Test
    @DisplayName("해당하는 로그인 아이디가 없는 회원을 조회 할 시")
    void notFindMember() {
        //given
        String loginId = "admin";
        //when
        SampleException exception = assertThrows(SampleException.class, () -> sampleService.getMemberInfo(loginId));
        //then
        assertEquals("100", exception.getError().getCode());
    }
}