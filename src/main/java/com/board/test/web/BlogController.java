package com.board.test.web;

import com.board.test.domain.blog.svc.BlogSVC;
import com.board.test.domain.entity.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
  @PostMapping("/add") // add.html의 Post요청시, http://localhost:9080/blog/add
  public String add(@RequestParam("title") String title,
                    @RequestParam("writer") String writer,
                    @RequestParam("bcontent") String bcontent,
                    Model model,
                    RedirectAttributes redirectAttributes) {
    Blog blog = new Blog();
    blog.setTitle(title);
    blog.setWriter(writer);
    blog.setBcontent(bcontent);

    Long blogId = blogSVC.save(blog);

//    // ★ 2-2) 게시판 조회 -> 새로고침시 POST 요청이 계속 되어 아래와 같이
//    Optional<Blog> findedBlog = blogSVC.findByID(blogId);
//    blog = findedBlog.orElseThrow();
//    model.addAttribute("blog", blog);
//    return "blog/detailForm";

    // ★ 2-3) POST 요청시 redirect를 이용하여 경로변수로 설정
    // add() 매개변수 RedirectAttributes 추가
    redirectAttributes.addAttribute("bid", blogId);
    return "redirect:/blog/{bid}/detail";
  }

  // ★ 4) 조회
  @GetMapping("/{bid}/detail") // GET, http://localhost:9080/blog/게시글번호/detail
  public String findById(@PathVariable("bid") Long blogId, Model model) {
    Optional<Blog> findedBlogId = blogSVC.findByID(blogId);
    Blog blog = findedBlogId.orElseThrow();
    model.addAttribute("blog", blog);

    return "blog/detailForm";
  }

  // ★ 5) 삭제
  @GetMapping("/{bid}/del")
  public String delete(@PathVariable("bid") Long blogId) {
    // 게시글 삭제 처리
    blogSVC.deleteById(blogId);

    return "redirect:/blog"; // 게시글 목록으로
  }

  // ★ 6) 여러건 삭제
  @PostMapping("/del") // all.html의 POST요청시, http://localhost:9080/blog/del
  public String deletedByIds(@RequestParam("bids") List<Long> bids) {
    blogSVC.deleteByIds(bids);

    return "redirect:/blog";
  }

  // ★ 7) 게시판 수정 양식
  @GetMapping("/{bid}/edit")
  public String updateForm(@PathVariable("bid") Long blogId, Model model) {
    Optional<Blog> modifiedBlog = blogSVC.findByID(blogId); // 수정할 게시글 번호
    Blog findBlog = modifiedBlog.orElseThrow(); // 게시글 번호의 정보 찾아오기
    model.addAttribute("blog", findBlog); // Model에 속성이름으로 불러오기

    return "blog/updateForm";
  }
  
  // ★ 8) 수정 처리
  @PostMapping("/{bid}/edit")
  public String update(@PathVariable("bid") Long blogId,
                       @RequestParam("title") String title,
                       @RequestParam("bcontent") String bcontent,
                       @RequestParam("writer") String writer,
                       RedirectAttributes redirectAttributes) {
    Blog blog = new Blog();
    blog.setTitle(title);
    blog.setBcontent(bcontent);
    blog.setWriter(writer);

    blogSVC.updateById(blogId, blog);

    redirectAttributes.addAttribute("bid", blogId);
    return "redirect:/blog/{bid}/detail";
  }

  
}
