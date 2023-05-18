CREATE SCHEMA if not exists ecommerce;


create table if not exists ecommerce.ratings (
    id                           INT GENERATED ALWAYS AS IDENTITY,
    user_id                        INT not null,
    item_id                        INT not null,
    starRating                     CHAR(10),
    review                         VARCHAR(255),
    PRIMARY KEY (id)
);