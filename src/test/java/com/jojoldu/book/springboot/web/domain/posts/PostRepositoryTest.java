package com.jojoldu.book.springboot.web.domain.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTest {

   @Autowired
    PostsRepository postsRepository;

   //junit 단위 테스트가 끝날 떄 마다 수행되는 메소드
   //테스터용 db 인 h2에 데이터가 그대로 남아있어 다음 테스트에 영향을 줄 수 있어서 비워주느 ㄴ메소드
   @AfterEach
    public void cleanup(){
       postsRepository.deleteAll();
   }

   @Test
    public void 게시글저장_불러오기(){
       //given
       String title = "테스트 게시글";
       String content = "테스트 본문";

       //테이블 posts에 insert/update 쿼리를 실행, id값이 있다면 update 업다면 insert
       postsRepository.save(Posts.builder()
               .title(title)
               .content(content)
               .author("jyansoony@gmail.com")
               .build());

       //테이블 posts에 있는 모든 데이터르 ㄹ조회해오는 메소드
       //when
       List<Posts> postsList = postsRepository.findAll();

       //then
       Posts posts = postsList.get(0);
       assertThat(posts.getTitle()).isEqualTo(title);
       assertThat(posts.getContent()).isEqualTo(content);
   }
}
