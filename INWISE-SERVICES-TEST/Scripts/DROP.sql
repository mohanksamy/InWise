--INVENTORY TABLES
DROP TABLE STOCK;
DROP TABLE STOCK_HISTORY;
DROP TABLE STOCK_BATCH;
DROP TABLE VENDOR;

--ORDER TABLES
DROP TABLE LINE_ITEM;
DROP TABLE INVOICE;
DROP TABLE BUYER;
DROP TABLE ITEM;

--DOMAIN TABLES
DROP TABLE CATEGORY;
DROP TABLE SUBCATEGORY;
DROP TABLE BRAND;
DROP TABLE MODEL;

DROP TABLE TAX;
DROP TABLE USERS;
DROP TABLE TRADER;
DROP TABLE ADDRESS;


--SEQUENCES will be dropped when the referred column is dropped