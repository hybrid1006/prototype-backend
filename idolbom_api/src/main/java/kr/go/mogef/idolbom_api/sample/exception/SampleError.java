package kr.go.mogef.idolbom_api.sample.exception;

import lombok.Getter;

@Getter
public enum SampleError {
    USER_NOT_FOUND("100", "사용자를 찾을 수 없습니다."),
    INVALID_INPUT("101", "잘못된 입력입니다."),
    INTERNAL_SERVER_ERROR("102", "서버 오류가 발생했습니다.");

    private final String code;
    private final String message;

    SampleError(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
