package com.board.test.domain.blog.dao;

import com.board.test.domain.entity.Blog;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BlogDAOImplTest {

  @Autowired // IOC컨테이너에 객체를 주입
  BlogDAO blogDAO;

  @Test
  @DisplayName("게시글작성")
  void save() {
    Blog blog = new Blog();
    blog.setTitle("Spring 공부하실분");
    blog.setBcontent("공부하실분 카톡하세요");
    blog.setWriter("김프링");

    Long blogId = blogDAO.save(blog);
    log.info("blogId={}", blogId);
  }
}