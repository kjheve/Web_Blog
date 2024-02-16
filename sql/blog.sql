-------- 삭제
-- 테이블 삭제
drop table blog;
-- 시퀀스 삭제
drop sequence blog_blog_id_seq;

---------
--상품관리
--------
create table blog(
    blog_id     number(10),  -- 게시글id
    title       varchar(90), -- 제목
    bcontent    clob,        -- 내용
    writer      varchar(15), -- 작성자
    cdate       timestamp,   -- 작성날짜
    udate       timestamp    -- 수정날짜
);
--기본키
alter table blog add constraint blog_blog_id primary key(blog_id);

--시퀀스생성
create sequence blog_blog_id_seq;

--디폴트
alter table blog modify cdate default systimestamp; -- 운영체제 일시를 기본값으로
alter table blog modify udate default systimestamp; -- 운영체제 일시를 기본값으로

--필수값들 NOT NULL
alter table blog modify title not null;
alter table blog modify writer not null;
alter table blog modify bcontent not null;

--생성--
insert into blog(blog_id, title, bcontent, writer)
     values(blog_blog_id_seq.nextval, '하이', '냉무', '김하이');

insert into blog(blog_id, title, bcontent, writer)
     values(blog_blog_id_seq.nextval, 'TEST임', '제곧내', '테스트');

insert into blog(blog_id, title, bcontent, writer)
     values(blog_blog_id_seq.nextval, '자바', '공부중', '학생');

commit;


------쿼리문 준비
--목록
select blog_id, title, bcontent, writer, cdate, udate
  from blog
  order by blog_id desc;

select count(*) from blog;

--단건조회
select blog_id, title, bcontent, writer, cdate, udate
  from blog
  where blog_id = 1;

--단건수정
update blog
  set title = 'DB공부중',
      bcontent = 'SQL공부하자',
      writer = '대학생',
      udate = systimestamp
  where blog_id = 2;

--단건삭제
delete from blog
  where blog_id = 1;
--여러건 삭제
delete from blog
  where blog_id in ( 1, 2, 3 );


rollback;
