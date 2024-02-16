package com.board.test.domain.blog.svc;

import com.board.test.domain.blog.dao.BlogDAO;
import com.board.test.domain.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogSVCImpl implements BlogSVC{
  private BlogDAO blogDAO;
  public BlogSVCImpl(BlogDAO blogDAO) {
    this.blogDAO = blogDAO;
  }

  // 1) 게시글 작성
  @Override
  public Long save(Blog blog) {
    return blogDAO.save(blog);
  }


  // 2) 1건 조회
  @Override
  public Optional<Blog> findByID(Long blogId) {
    return blogDAO.findByID(blogId);
  }

  // 3) 전체 조회
  @Override
  public List<Blog> findAll() {
    return blogDAO.findAll();
  }

  // 4) 1건 삭제
  @Override
  public int deleteById(Long blogId) {
    return blogDAO.deleteById(blogId);
  }
}
