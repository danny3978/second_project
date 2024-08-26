-- auto-generated definition
create table comment
(
    id          bigint auto_increment
        primary key,
    create_at   datetime(6)  null,
    modified_at datetime(6)  null,
    comment     varchar(255) null,
    schedule_id bigint       null,
    constraint FKsy51iks4dgapu66gfj3mnykch
        foreign key (schedule_id) references schedule (id)
);


create table schedule
(
    id            bigint auto_increment
        primary key,
    create_at     datetime(6)  null,
    modified_at   datetime(6)  null,
    to_do_comment varchar(255) null,
    to_do_title   varchar(255) null,
    user_id       bigint       null,
    constraint FKdn5svbxyacce1gpfiawk7iqtc
        foreign key (user_id) references users (id)
);


create table users
(
    id          bigint auto_increment
        primary key,
    create_at   datetime(6)  null,
    modified_at datetime(6)  null,
    email       varchar(255) null,
    username    varchar(255) null
);