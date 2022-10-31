package com.jojiapp.springswagger.member.controller;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "회원", description = "회원 API")
@RestController
@RequestMapping("/members")
public class MemberController {

    @Tag(name = "회원")
    @ApiOperation(value = "회원 등록", notes = "회원을 등록합니다.")
    @ApiResponses(value =  {
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 400, message = "잘못된 요청입니다.")
    })
    @PostMapping
    public void save(@RequestBody MemberCreate memberCreate) {}

    @Tags(value = {
            @Tag(name = "회원"),
            @Tag(name = "회원조회"),
    })
    @ApiOperation(value = "회원 식별키로 조회", notes = "회원 단건 조회")
    @ApiImplicitParam(name="id", value = "회원 식별키", dataTypeClass = Long.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공", response = MemberResponse.class),
            @ApiResponse(code = 400, message = "존재하지 않는 회원입니다.")
    })
    @GetMapping("/{id}")
    public MemberResponse getById(@PathVariable final Long id) {
        return new MemberResponse();
    }

    @Tags(value = {
            @Tag(name = "회원"),
            @Tag(name = "회원조회"),
    })
    @ApiOperation(value = "회원 이름으로 조회", notes = "회원 단건 조회")
    @ApiImplicitParam(name="name", value = "회원 이름", dataTypeClass = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공", response = MemberResponse.class),
            @ApiResponse(code = 400, message = "존재하지 않는 회원입니다.")
    })
    @GetMapping
    public MemberResponse getByName(final String name) {

        return new MemberResponse();
    }

}
