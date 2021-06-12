create sequence hibernate_sequence start 1 increment 1

    create table categories (
       id int8 not null,
        img varchar(255),
        subtitle varchar(255),
        title varchar(255),
        primary key (id)
    )

    create table categories_foods (
       category_id int8 not null,
        foods_id int8 not null,
        primary key (category_id, foods_id)
    )

    create table foods (
       id int8 not null,
        available boolean not null,
        avg_review int4 not null,
        description varchar(255),
        img varchar(255),
        price float8 not null,
        title varchar(255),
        category_id int8,
        primary key (id)
    )

    create table foods_order_collections (
       food_id int8 not null,
        order_collections_id int8 not null,
        primary key (food_id, order_collections_id)
    )

    create table order_collections (
       id int8 not null,
        quantity int4 not null,
        food_id int8,
        order_id int8,
        primary key (id)
    )

    create table orders (
       id int8 not null,
        company_name varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        notes varchar(255),
        payment_method varchar(255),
        phone varchar(255),
        street_address varchar(255),
        sub_total float8 not null,
        transaction_id varchar(255),
        primary key (id)
    )

    create table orders_order_collections (
       order_id int8 not null,
        order_collections_id int8 not null,
        primary key (order_id, order_collections_id)
    )

    alter table categories_foods 
       add constraint UK_ea2nwqitrd6wfrnvnirnn7k38 unique (foods_id)

    alter table foods_order_collections 
       add constraint UK_732ar2dmg49rfu596r2wxu5qs unique (order_collections_id)

    alter table orders_order_collections 
       add constraint UK_t1f6p4eym5co0ydiws2ppcayx unique (order_collections_id)

    alter table categories_foods 
       add constraint FK3fpo5tybx39u8f8vqs1ldej1h 
       foreign key (foods_id) 
       references foods

    alter table categories_foods 
       add constraint FKrrm1evjxbr65nvjgxni1tlkbg 
       foreign key (category_id) 
       references categories

    alter table foods 
       add constraint FKpaltlojk6ds73o9vn3f2ri9gk 
       foreign key (category_id) 
       references categories

    alter table foods_order_collections 
       add constraint FKgm9drlstsai394tm1mqie0o61 
       foreign key (order_collections_id) 
       references order_collections

    alter table foods_order_collections 
       add constraint FK6i5nytbkdwlyiudx48a3wha0 
       foreign key (food_id) 
       references foods

    alter table order_collections 
       add constraint FKjw81oi678ayvw31kxtkdhq9nv 
       foreign key (food_id) 
       references foods

    alter table order_collections 
       add constraint FKltpialm80ohy5ivb4xb4x5su8 
       foreign key (order_id) 
       references orders

    alter table orders_order_collections 
       add constraint FK8l6ctans3xgm2axysasebc9vt 
       foreign key (order_collections_id) 
       references order_collections

    alter table orders_order_collections 
       add constraint FK1yf1hr06gwjw0ndegtyyj7ea4 
       foreign key (order_id) 
       references orders
