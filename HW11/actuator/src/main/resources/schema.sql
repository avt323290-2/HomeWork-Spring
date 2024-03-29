create table if not exists notes
(
    id          INT AUTO_INCREMENT primary key,
    title       varchar(200) not null,
    description varchar(200) not null,
    create_date timestamp    not null
);