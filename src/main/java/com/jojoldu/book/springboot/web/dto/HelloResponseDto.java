package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
// 선언된 필드가 포함된 생성자 생성( final이 없는 필드는 생성되지 않음)
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
