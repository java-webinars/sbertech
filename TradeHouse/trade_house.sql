DROP TABLE IF EXISTS th_order_item;
DROP TABLE IF EXISTS th_order;
DROP TABLE IF EXISTS th_customer;
DROP TABLE IF EXISTS th_product;

CREATE TABLE th_product
(
	product_id SERIAL PRIMARY KEY,
	product_name varchar(100)
);

CREATE TABLE th_customer
(
	customer_id varchar(100) PRIMARY KEY,
	first_name varchar(100),
	last_name varchar(100),
	phone varchar(25),
	email varchar(100)
);

CREATE TABLE th_order
(
	order_id SERIAL PRIMARY KEY,
	customer_id varchar(100) REFERENCES th_customer (customer_id),
	order_date timestamp
);

CREATE TABLE th_order_item
(
	order_item_id SERIAL PRIMARY KEY,
	order_id integer REFERENCES th_order (order_id),
	product_id integer REFERENCES th_product (product_id),
	quantity integer,
	price numeric
);

insert into th_customer VALUES ('1', 'Peter', 'Parker', '+7xxx', 'parker@pisem.net');