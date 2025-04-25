
DROP TABLE IF EXISTS TBL_PRODUCT;
DROP TABLE IF EXISTS TBL_GRP_PRODUCT;


create table TBL_GRP_PRODUCT
(
    id         serial constraint grpproduct_pk primary key,
    name       varchar not null
);

create table TBL_PRODUCT
(
    id         serial constraint product_pk primary key,
    grp_product_id integer not null constraint city_country_fk references TBL_GRP_PRODUCT,
    name       varchar not null
);
commit;