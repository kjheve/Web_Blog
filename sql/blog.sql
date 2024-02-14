-------- ����
-- ���̺� ����
drop table blog;
-- ������ ����
drop sequence blog_blog_id_seq;

---------
--��ǰ����
--------
create table blog(
    blog_id     number(10),  -- �Խñ�id
    title       varchar(90), -- ����
    bcontent    clob,        -- ����
    writer      varchar(15), -- �ۼ���
    cdate       timestamp,   -- �ۼ���¥
    udate       timestamp    -- ������¥
);
--�⺻Ű
alter table blog add constraint blog_blog_id primary key(blog_id);

--����������
create sequence blog_blog_id_seq;

--����Ʈ
alter table blog modify cdate default systimestamp; -- �ü�� �Ͻø� �⺻������
alter table blog modify udate default systimestamp; -- �ü�� �Ͻø� �⺻������

--����--
insert into blog(blog_id, title, bcontent, writer)
     values(blog_blog_id_seq.nextval, '����', '�ù�', '������');

insert into blog(blog_id, title, bcontent, writer)
     values(blog_blog_id_seq.nextval, 'TEST��', '����', '�׽�Ʈ');

insert into blog(blog_id, title, bcontent, writer)
     values(blog_blog_id_seq.nextval, '�ڹ�', '������', '�л�');
     
commit;


------������ �غ�
--���
select blog_id, title, bcontent, writer, cdate, udate
  from blog
  order by blog_id desc;
  
select count(*) from blog;
  
--�ܰ���ȸ
select blog_id, title, bcontent, writer, cdate, udate
  from blog
  where blog_id = 1;
  
--�ܰǼ���
update blog
  set title = 'DB������',
      bcontent = 'SQL��������',
      writer = '���л�',
      udate = systimestamp
  where blog_id = 2;
  
--�ܰǻ���
delete from blog
  where blog_id = 1;
--������ ����
delete from blog
  where blog_id in ( 1, 2, 3 );


rollback;
