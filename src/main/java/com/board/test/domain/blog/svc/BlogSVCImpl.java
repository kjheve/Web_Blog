package com.board.test.domain.blog.svc;

import com.board.test.domain.blog.dao.BlogDAO;
import com.board.test.domain.entity.Blog;
import org.springframework.stereotype.Service;

@Service
public class BlogSVCImpl implements BlogSVC{

  // IOC
  private BlogDAO blogDAO;
  // DI
  public BlogSVCImpl(BlogDAO blogDAO) {
    this.blogDAO = blogDAO;
  }

  // 1. 게시글 작성
  @Override
  public Long save(Blog blog) {
    return blogDAO.save(blog);
  }
}
