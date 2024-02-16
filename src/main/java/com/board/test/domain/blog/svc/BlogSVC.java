package com.board.test.domain.blog.svc;

import com.board.test.domain.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogSVC {
  // 1) 게시글 작성
  Long save(Blog blog);

  // 2) 1건 조회
  Optional<Blog> findByID(Long blogId);

  // 3) 전체 조회
  List<Blog> findAll();

  // 4) 1건 삭제
  int deleteById(Long blogId);
}
