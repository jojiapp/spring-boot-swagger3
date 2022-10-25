package com.jojiapp.springswagger.member.controller;

import io.swagger.annotations.*;
import lombok.*;

@ApiModel(value = "회원 등록")
@NoArgsConstructor
@Getter
@Setter
public class MemberCreate {

    @ApiModelProperty(value = "이름", notes = "회원의 이름", example = "홍길동")
    private String name;
}
