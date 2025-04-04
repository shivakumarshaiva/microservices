create table if not exists customer (
    customer_id int auto_increment primary  key,
    name varchar(255),
    email varchar(255),
    mobile_number varchar(255),
    created_at date not null,
    created_by varchar(255),
    updated_at date default null,
    updated_by varchar(255) default null
);

create table if not exists accounts (
    customer_id int not null,
    account_number int auto_increment primary key,
    account_type varchar(255),
    branch_address varchar(255),
    created_at date not null,
    created_by varchar(255),
    updated_at date default null,
    updated_by varchar(255) default null
);