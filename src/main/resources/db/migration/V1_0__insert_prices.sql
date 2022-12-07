CREATE TABLE prices (
	id integer NOT NULL,
	brand_id integer NOT NULL,
	start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    price_list integer NOT NULL,
    product_id integer NOT NULL,
    priority integer NOT NULL,
    price decfloat NOT NULL,
    currency varchar NOT NULL
);

INSERT INTO prices values(0,1,'2020-06-14 00.00.00','2020-12-31 23.59.59',1,35455,0,35.50,'EUR');
INSERT INTO prices values(0,1,'2020-06-14 15.00.00','2020-06-14 18.30.00',2,35455,1,25.45,'EUR');
INSERT INTO prices values(0,1,'2020-06-15 00.00.00','2020-06-15 11.00.00',3,35455,1,30.50,'EUR');
INSERT INTO prices values(0,1,'2020-06-15 16.00.00','2020-12-31 23.59.59',4,35455,1,38.95,'EUR');