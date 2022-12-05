package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@NoArgsConstructor:기본 생성자 자동 추가 public Posts(){}와 같은 효과
//@Entity:테이블과 링크될 클래스임을 나타냄
@Getter
@NoArgsConstructor
@Entity
public class Posts {
    //@Id:해당 테이블의 pk
    //@GeneratedValue:pk의 생성 규칙을 나타냄
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //테이브르이 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스 생성 , 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


}
