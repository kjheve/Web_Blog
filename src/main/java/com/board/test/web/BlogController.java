package com.board.test.web;

import com.board.test.domain.blog.svc.BlogSVC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/blog") // URL매핑 http://localhost:9080/blog
public class BlogController {
  private BlogSVC blogSVC;
  public BlogController(BlogSVC blogSVC) {
    this.blogSVC = blogSVC;
  }

  // 게시판 등록 양식
  @GetMapping("/add") // Get, http://localhost:9080/blog/add
  public String addForm() {
    return "blog/add";
  }
}
