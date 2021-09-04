create table if not exists customers(
    id bigserial primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    address varchar(255) not null,
    budget bigint not null
);