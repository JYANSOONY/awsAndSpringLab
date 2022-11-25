package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
//테이블과 링크될 클래스임을 나타냄
@Entity
public class Posts {
    //해당 테이블의 pk
    @Id
    //pk의 생성 규칙을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //테이브르이 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


}
