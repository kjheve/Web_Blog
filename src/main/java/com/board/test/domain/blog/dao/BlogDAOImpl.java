package com.board.test.domain.blog.dao;

import com.board.test.domain.entity.Blog;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BlogDAOImpl implements BlogDAO{

  // IOC
  private final NamedParameterJdbcTemplate template;
  // DI
  public BlogDAOImpl(NamedParameterJdbcTemplate template) {
    this.template = template;
  }

  // ★1. 게시글 작성
  @Override
  public Long save(Blog blog) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert into blog(blog_id,title,bcontent,writer) ");
    sql.append("values(blog_blog_id_seq.nextval, :title, :bcontent, :writer) ");

    SqlParameterSource param = new BeanPropertySqlParameterSource(blog);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    template.update(sql.toString(), param, keyHolder, new String[]{"blog_id"});
    long blogId = keyHolder.getKey().longValue();
    return blogId;
  }
}
