package com.jojiapp.springswagger.member.controller;

import io.swagger.annotations.*;
import lombok.*;

@ApiModel(value = "회원 정보 응답")
@NoArgsConstructor
@Getter
public class MemberResponse {

    @ApiModelProperty(name = "이름", example = "조지헌")
    private String name;
}
