DROP TABLE IF EXISTS DETAIL_LINE;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS `ORDER`;
DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS SELLER;
DROP TABLE IF EXISTS LOCALITY;

create table SELLER(
    seller_id   varchar(45),
    firstname   varchar(45) not null,
    lastname    varchar(45) not null,
    hiring_date  date default (current_date),
    constraint seller_id_pk primary key (seller_id)
);

create table LOCALITY(
    locality_id varchar(45),
    zip_code    int not null,
    `name`      varchar(45) not null,
    CHECK (zip_code > 0),
    constraint locality_id_pk primary key (locality_id)
);

create table CUSTOMER(
    customer_id             varchar(45),
    firstname               varchar(45) not null,
    lastname                varchar(45) not null,
    account_number          varchar(45),
    payment_type            varchar(45) not null,
    billing_street          varchar(45) not null,
    billing_street_number   varchar(45) not null,
    locality_fk             varchar(45) not null,
    constraint customer_id_pk primary key (customer_id),
    constraint locality_fk foreign key (locality_fk) references LOCALITY(locality_id)
);

create table `ORDER`(
    order_id                varchar(45),
    seller_fk               varchar(45) not null,
    customer_fk             varchar(45) not null,
    order_date            date default (current_date),
    sent_date               date,
    withdraw_date           date,
    payement_deadline       date not null,
    receipt_date            date,
    number_payment_reminder int default 0,
    is_paid                 boolean not null,
    is_delivered            boolean not null,
    delivery_street         varchar(45),
    delivery_street_number  varchar(45),
    locality_fk             varchar(45),
    CHECK (number_payment_reminder >= 0),
    constraint order_id_pk primary key (order_id),
    constraint seller_fk foreign key (seller_fk) references SELLER(seller_id),
    constraint customer_fk foreign key (customer_fk) references CUSTOMER(customer_id),
    constraint locality_fk_2 foreign key (locality_fk) references LOCALITY(locality_id)
);

create table PRODUCT(
    code    varchar(45),
    `name`  varchar(45) not null,
    price   double not null,
    VAT     double not null,
    CHECK (price > 0),
    CHECK (VAT >= 0 AND VAT <= 1),
    constraint code_pk primary key (code)
);

create table DETAIL_LINE(
    order_fk    varchar(45),
    product_fk  varchar(45),
    reduction   double,
    sell_price  double not null,
    quantity    int not null,
    CHECK (sell_price > 0),
    CHECK (quantity > 0),
    CHECK (reduction <= 1 AND reduction >= 0),
    constraint detail_line_pk primary key (order_fk, product_fk),
    constraint order_fk foreign key (order_fk) references `ORDER`(order_id),
    constraint product_fk foreign key (product_fk) references PRODUCT(code)   
    
);