package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
//WEBMVCTEST 경우 JPA적용이 작동하지 않기 때문에 스프링부트테스트 사용
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void main_loading(){
        //when
        String body = this.restTemplate.getForObject("/", String.class);
        
        //then
        assertThat(body).contains("스프링 부트로 시작하는 웹서비스");
    }
}
