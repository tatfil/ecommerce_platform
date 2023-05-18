CREATE SCHEMA if not exists ecommerce;


create table if not exists ecommerce.orders (
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    address character varying(255),
    attached_file oid,
    creation_date timestamp without time zone,
    items_count integer,
    status character varying(255),
    requester integer,
    responsible integer,
    PRIMARY KEY (id)
);


create table if not exists ecommerce.order_items (
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    attached_file oid,
    comment character varying(255),
    merch_item integer,
    quantity bigint NOT NULL,
    undelivered_quantity bigint,
    order_id integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES ecommerce.orders (id)
);

CREATE TABLE IF NOT EXISTS ecommerce.users (
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    account_status integer,
    balance numeric(19,2),
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    user_name character varying(255) NOT NULL,
    PRIMARY KEY (id)
)
