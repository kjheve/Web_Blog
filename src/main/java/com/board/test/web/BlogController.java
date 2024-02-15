package com.board.test.web;

import com.board.test.domain.blog.svc.BlogSVC;
import com.board.test.domain.entity.Blog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog") // URL매핑 http://localhost:9080/blog
public class BlogController {
  private BlogSVC blogSVC;
  public BlogController(BlogSVC blogSVC) {
    this.blogSVC = blogSVC;
  }

  // ★ 3) 게시판 목록
  @GetMapping // GET, http://localhost:9080/blog
  public String findAll(Model model) {
    List<Blog> list = blogSVC.findAll();
    model.addAttribute("list", list);
    return "blog/all";
  }

  // ★ 1) 게시판 등록 양식
  @GetMapping("/add") // Get, http://localhost:9080/blog/add
  public String addForm() {
    return "blog/add";
  }
  
  // ★ 2) 게시판 등록 처리
  @PostMapping("/add") // Post, http://localhost:9080/blog/add
  public String add(@RequestParam("title") String title,
                    @RequestParam("writer") String writer,
                    @RequestParam("bcontent") String bcontent,
                    Model model) {
    Blog blog = new Blog();
    blog.setTitle(title);
    blog.setWriter(writer);
    blog.setBcontent(bcontent);
    Long blogId = blogSVC.save(blog);
    
    // ★ 2-2) 게시판 조회
    Optional<Blog> findedBlog = blogSVC.findByID(blogId);
    blog = findedBlog.orElseThrow();

    model.addAttribute("blog", blog);
    return "blog/detailForm";
  }

  // ★ 4) 조회
  @GetMapping("/{bid}/detail") // GET, http://localhost:9080/blog/게시글번호/detail
  public String findById(@PathVariable("bid") Long blogId, Model model) {
    Optional<Blog> findedBlogId = blogSVC.findByID(blogId);
    Blog blog = findedBlogId.orElseThrow();
    model.addAttribute("blog", blog);

    return "blog/detailForm";
  }



  
}
