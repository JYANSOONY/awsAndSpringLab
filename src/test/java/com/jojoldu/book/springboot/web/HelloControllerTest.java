package com.jojoldu.book.springboot.web;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//스프링부트와 junit과의 연결자 역할
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
//     스프링이 관리하는 빈 주입
    @Autowired
//    웹 API를 테스트할 때 쓰임
    private MockMvc mvc;

    @Test
    public void hello가_test() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
//                mvc.perform의 결과와 HTTP Header의 status 검증 (200인지 아닌지)
                .andExpect(status().isOk())
//                mvc.perform의 결과검증, 리턴 하는 hello가 맞는지 검증
                .andExpect(content().string(hello));
    }
}
