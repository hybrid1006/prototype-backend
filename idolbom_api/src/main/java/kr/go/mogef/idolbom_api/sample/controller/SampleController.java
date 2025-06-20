package kr.go.mogef.idolbom_api.sample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kr.go.mogef.idolbom_api.common.ApiResponse;
import kr.go.mogef.idolbom_api.sample.dto.GetSampleRequestDto;
import kr.go.mogef.idolbom_api.sample.dto.GetSampleResponseDto;
import kr.go.mogef.idolbom_api.sample.dto.PostSampleRequestDto;
import kr.go.mogef.idolbom_api.sample.dto.PostSampleResponseDto;
import kr.go.mogef.idolbom_api.sample.exception.SampleException;
import kr.go.mogef.idolbom_api.sample.mapper.SampleMapper;
import kr.go.mogef.idolbom_api.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    private final SampleMapper sampleMapper;

    @Operation(summary = "get 방식 예제", description = "LOGIN ID를 통해 정보를 조회합니다.")
    @GetMapping("/get-sample/{loginId}")
    public ApiResponse<GetSampleResponseDto> getSample(@Parameter(description = "조회할 항목의 LOGIN ID") @PathVariable String loginId) {
        return ApiResponse.success(sampleService.getMemberInfo(loginId));
    }

    @Operation(summary = "post 방식 예제", description = "LOGIN ID를 통해 정보를 조회합니다.")
    @ResponseBody
    @PostMapping("/get-sample")
    public ApiResponse<GetSampleResponseDto> getSample(@RequestBody GetSampleRequestDto dto) {
        try {
            GetSampleResponseDto result = sampleMapper.selectMember(dto.getLoginId());
            return ApiResponse.success(result);
//            return ApiResponse.success(sampleService.getMemberQuerydsl(dto));
        } catch (SampleException e) {
            log.error("{} {} : {}",e.getClass(), e.getError().getCode(), e.getError().getMessage());
            return ApiResponse.error(e.getError().getCode(), e.getError().getMessage());
        }
    }

    @Operation(summary = "등록 수정 예제", description = "등록 또는 수정하는 예제입니다. (더티체킹을 이용한 update 및 save를 통한 등록) ")
    @ResponseBody
    @PostMapping("/save")
    public ApiResponse<PostSampleResponseDto> save(@RequestBody PostSampleRequestDto dto) {
        try {
            return ApiResponse.success(sampleService.save(dto));
        } catch (SampleException e) {
            return ApiResponse.error(e.getError().getCode(), e.getError().getMessage());
        }
    }
}
