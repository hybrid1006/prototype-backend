package kr.go.mogef.idolbom_api.sample.exception;

import lombok.Getter;

@Getter
public class SampleException extends RuntimeException{
    private final SampleError error;


    public SampleException(SampleError error) {
        super(error.getMessage());
        this.error = error;
    }


}
