DROP TABLE stock_market;

CREATE TABLE stock_market(
stock_id serial PRIMARY KEY,
stock_company_name varchar(50),
stock_ticker varchar(6),
stock_market_cap decimal(10,2),
stock_quantity_total int,
stock_quantity_available int
);


INSERT INTO stock_market VALUES(DEFAULT, 'Microsoft', 'MSFT', 1000000, 10, 10 ); 
INSERT INTO stock_market VALUES(DEFAULT, 'Google', 'GOOG', 1000, 100, 100 );
INSERT INTO stock_market VALUES(DEFAULT, 'Apple', 'APPL', 500000, 100, 100 );
INSERT INTO stock_market VALUES(DEFAULT, 'Amazon', 'AMZN', 800000, 100, 100 );

SELECT * FROM stock_market;