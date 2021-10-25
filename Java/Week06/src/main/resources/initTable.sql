create table if not exists user
(
    user_id   int auto_increment
    primary key,
    user_name varchar(255) null,
    constraint user_user_name_uindex
    unique (user_name)
);

create table if not exists `order`
(
    order_id     int not null,
    commodity_id int not null,
    user_id      int not null,
    constraint order_order_id_uindex
    unique (order_id)
    );
alter table `order` add primary key (order_id);

create table if not exists commodity
(
    commodity_id   int not null,
    commodity_name int not null,
    constraint commodity_commodity_id_uindex
    unique (commodity_id)
    );
alter table commodity add primary key (commodity_id);