
    create table cart (
       id  bigserial not null,
        primary key (id)
    );

    create table cart_item (
       id  bigserial not null,
        price float8,
        quantity int4,
        cartitem_product_fk int8,
        cart_cartitem_fk int8,
        primary key (id)
    );

    create table product (
       id  bigserial not null,
        name varchar(255),
        price float8,
        primary key (id)
    );

    alter table cart_item
       add constraint FKjr4nigi0nfwxuh5y5q4xpk9mg
       foreign key (cartitem_product_fk)
       references product;

    alter table cart_item
       add constraint FK2ajema53ksr3etjoclponyjcn
       foreign key (cart_cartitem_fk)
       references cart;