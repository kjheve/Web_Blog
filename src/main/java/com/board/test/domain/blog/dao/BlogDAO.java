package com.board.test.domain.blog.dao;

import com.board.test.domain.entity.Blog;

public interface BlogDAO {
  // ★ 1.게시글 작성
  Long save(Blog blog);
}
