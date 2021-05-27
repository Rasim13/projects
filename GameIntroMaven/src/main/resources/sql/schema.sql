create table player (
    id bigserial primary key,
    nickname varchar(30) unique not null,
    score int,
    wins_count int,
    loses_count int
);

create table message (
  id bigserial primary key,
  text varchar(500),
  date_time varchar(100)
);

create table tag_message (
  tags varchar(100),
  message_id bigint,
  foreign key (message_id) references message (id)
);