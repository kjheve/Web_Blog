package com.board.test.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Blog {
  private Long blogId;          // BLOG_ID	NUMBER(10,0)      // 게시글 id
  private String title;          // TITLE	VARCHAR2(90 BYTE)   // 게시글 제목
  private String bcontent;       // BCONTENT	CLOB            // 게시글 내용
  private String writer;         // WRITER	VARCHAR2(15 BYTE) // 작성자
  private LocalDateTime cdate;   // CDATE	TIMESTAMP(6)        // 작성날짜
  private LocalDateTime udate;   // UDATE	TIMESTAMP(6)        // 수정날짜
}
