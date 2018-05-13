# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  id                            varchar(255) not null,
  order_number                  integer,
  name                          varchar(255),
  date                          date,
  operation                     varchar(255),
  user_id                       integer,
  user_name                     varchar(255),
  constraint pk_book primary key (id)
);

create table table_dept (
  id                            bigint auto_increment not null,
  location                      varchar(255),
  name                          varchar(255),
  constraint pk_table_dept primary key (id)
);

create table table_user (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  account                       varchar(255),
  dept_id                       bigint,
  constraint pk_table_user primary key (id)
);

alter table table_user add constraint fk_table_user_dept_id foreign key (dept_id) references table_dept (id) on delete restrict on update restrict;
create index ix_table_user_dept_id on table_user (dept_id);


# --- !Downs

alter table table_user drop foreign key fk_table_user_dept_id;
drop index ix_table_user_dept_id on table_user;

drop table if exists book;

drop table if exists table_dept;

drop table if exists table_user;

