package com.kt.yoon.domain.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ResponseForm {
    @NotEmpty(message = "멤버id는 필수 입니다.")
    private String memberId;

    @NotEmpty(message = "시트id는 필수 입니다.")
    private String sheetId;

    @NotEmpty(message = "응답은 필수 입니다.")
    @Size(max = 2000, message = "응답항목은 2000자를 넘을수 없습니다.")
    private String response;
}

