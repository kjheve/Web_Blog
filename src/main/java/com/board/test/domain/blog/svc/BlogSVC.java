package com.board.test.domain.blog.svc;

import com.board.test.domain.entity.Blog;

public interface BlogSVC {
  // 1. 게시글 작성
  Long save(Blog blog);
}
