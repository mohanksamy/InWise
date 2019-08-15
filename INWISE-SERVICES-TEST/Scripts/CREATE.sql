


---------------------------------------------------------------------------
--						TIMESTAMP TRIGGER
---------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION TRIGGER_FN()
RETURNS trigger AS '
	BEGIN
		IF TG_OP = ''INSERT'' THEN
			NEW.CREATED_TS 	:= NOW();
			NEW.MODIFIED_TS := NOW();

		ELSIF TG_OP = ''UPDATE'' THEN
			NEW.CREATED_TS 	:= OLD.CREATED_TS;
			NEW.MODIFIED_TS := NOW();
		END IF; 
		
		RETURN NEW;
	END'
LANGUAGE 'plpgsql';



---------------------------------------------------------------------------
--						TABLE: ADDRESS
---------------------------------------------------------------------------

CREATE TABLE ADDRESS (
	ID				BIGSERIAL,
	STREET1			TEXT 		NOT NULL,
	STREET2			TEXT,
	CITY				TEXT 		NOT NULL,
	REGION			TEXT,
	STATE			TEXT 		NOT NULL,
	COUNTRY			TEXT 		NOT NULL,
	POSTALCODE		TEXT,
	ACTIVE			BOOLEAN		NOT NULL,
	CREATED_USER		TEXT			NOT NULL,
	CREATED_TS		TIMESTAMP	NOT NULL,
	MODIFIED_USER	TEXT			NOT NULL,
	MODIFIED_TS		TIMESTAMP	NOT NULL,
	PRIMARY KEY     (ID)
);

CREATE TRIGGER ADDRESS_BIT
	BEFORE INSERT OR UPDATE ON ADDRESS
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: TRADER
---------------------------------------------------------------------------

CREATE TABLE TRADER (
	ID              	BIGSERIAL,
	NAME            	TEXT        		NOT NULL,
	CODE            	TEXT        		NOT NULL,
	ADDRESS_ID      BIGINT      		NOT NULL,
	UIN             	TEXT,
	PHONE           	BIGINT      		NOT NULL,
	ACTIVE          	BOOLEAN     		NOT NULL,
	CREATED_USER    	TEXT        		NOT NULL,
	CREATED_TS      	TIMESTAMP   		NOT NULL,
	MODIFIED_USER   	TEXT        		NOT NULL,
	MODIFIED_TS     	TIMESTAMP   		NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(ADDRESS_ID)		REFERENCES ADDRESS (ID)
);

CREATE TRIGGER TRADER_BIT
	BEFORE INSERT OR UPDATE ON TRADER
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: TAX
---------------------------------------------------------------------------

CREATE TABLE TAX (
  	ID              	BIGSERIAL,
	CGST            	DECIMAL(12,2)	NOT NULL,
	SGST            	DECIMAL(12,2)	NOT NULL,
	TRADER_ID     	BIGINT      		NOT NULL,
	ACTIVE          	BOOLEAN     		NOT NULL,
	CREATED_USER    	TEXT        		NOT NULL,
	CREATED_TS      	TIMESTAMP   		NOT NULL,
	MODIFIED_USER   	TEXT        		NOT NULL,
	MODIFIED_TS     	TIMESTAMP   		NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(TRADER_ID)  	REFERENCES TRADER (ID)
);

CREATE TRIGGER TAX_BIT
	BEFORE INSERT OR UPDATE ON TAX
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: CATEGORY
---------------------------------------------------------------------------

CREATE TABLE CATEGORY (
	ID              	BIGSERIAL,
	NAME            	TEXT			NOT NULL,
	CODE            	TEXT        NOT NULL,
	TRADER_ID     	BIGINT      NOT NULL,
	ACTIVE          	BOOLEAN     NOT NULL,
	CREATED_USER    	TEXT        NOT NULL,
	CREATED_TS      	TIMESTAMP   NOT NULL,
	MODIFIED_USER   	TEXT        NOT NULL,
	MODIFIED_TS     	TIMESTAMP   NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(TRADER_ID)	REFERENCES TRADER (ID)
);

CREATE TRIGGER CATEGORY_BIT
	BEFORE INSERT OR UPDATE ON CATEGORY
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: SUBCATEGORY
---------------------------------------------------------------------------

CREATE TABLE SUBCATEGORY (
	ID              	BIGSERIAL,
	NAME            	TEXT			NOT NULL,
	CODE            	TEXT        NOT NULL,
	TRADER_ID     	BIGINT      NOT NULL,
	ACTIVE          	BOOLEAN     NOT NULL,
	CREATED_USER    	TEXT        NOT NULL,
	CREATED_TS      	TIMESTAMP   NOT NULL,
	MODIFIED_USER   	TEXT        NOT NULL,
	MODIFIED_TS     	TIMESTAMP   NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(TRADER_ID)	REFERENCES TRADER (ID)
);

CREATE TRIGGER SUBCATEGORY_BIT
	BEFORE INSERT OR UPDATE ON SUBCATEGORY
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: BRAND
---------------------------------------------------------------------------

CREATE TABLE BRAND (
	ID				BIGSERIAL,
	NAME				TEXT			NOT NULL,
	CODE            	TEXT        NOT NULL,
	TRADER_ID     	BIGINT      NOT NULL,
	ACTIVE          	BOOLEAN     NOT NULL,
	CREATED_USER    	TEXT        NOT NULL,
	CREATED_TS      	TIMESTAMP   NOT NULL,
	MODIFIED_USER   	TEXT        NOT NULL,
	MODIFIED_TS     	TIMESTAMP   NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(TRADER_ID)	REFERENCES TRADER (ID)
);

CREATE TRIGGER BRAND_BIT
	BEFORE INSERT OR UPDATE ON BRAND
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: MODEL
---------------------------------------------------------------------------

CREATE TABLE MODEL (
	ID              	BIGSERIAL,
	NAME            	TEXT			NOT NULL,
	CODE            	TEXT        NOT NULL,
	TRADER_ID     	BIGINT      NOT NULL,
	ACTIVE          	BOOLEAN     NOT NULL,
	CREATED_USER    	TEXT        NOT NULL,
	CREATED_TS      	TIMESTAMP   NOT NULL,
	MODIFIED_USER   	TEXT        NOT NULL,
	MODIFIED_TS     	TIMESTAMP   NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(TRADER_ID)	REFERENCES TRADER (ID)
);

CREATE TRIGGER MODEL_BIT
	BEFORE INSERT OR UPDATE ON MODEL
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: ITEM
---------------------------------------------------------------------------

CREATE TABLE ITEM (
	ID              	BIGSERIAL,
	NAME            	TEXT        			NOT NULL,
	CODE            	TEXT        			NOT NULL,
	PART_NO         	BIGINT,
	PRICE           	DECIMAL(12,2)		NOT NULL,
	HSN_SAC         	TEXT,
	CATEGORY_ID		BIGINT,
	SUBCATEGORY_ID	BIGINT,
	BRAND_ID			BIGINT,
	MODEL_ID			BIGINT,
	TRADER_ID     	BIGINT      			NOT NULL,
	TAX_ID          	BIGINT      			NOT NULL,
	ACTIVE          	BOOLEAN     			NOT NULL,
	CREATED_USER    	TEXT        			NOT NULL,
	CREATED_TS      	TIMESTAMP   			NOT NULL,
	MODIFIED_USER   	TEXT        			NOT NULL,
	MODIFIED_TS     	TIMESTAMP   			NOT NULL,
  	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(TRADER_ID)			REFERENCES TRADER (ID),
	FOREIGN KEY     	(TAX_ID)    			REFERENCES TAX (ID),
	FOREIGN KEY     	(CATEGORY_ID)  		REFERENCES CATEGORY (ID),
	FOREIGN KEY     	(SUBCATEGORY_ID)  	REFERENCES SUBCATEGORY (ID),
	FOREIGN KEY     	(BRAND_ID)  			REFERENCES BRAND (ID),
	FOREIGN KEY     	(MODEL_ID)  			REFERENCES MODEL (ID)
);
	
CREATE TRIGGER ITEM_BIT
	BEFORE INSERT OR UPDATE ON ITEM
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: BUYER
---------------------------------------------------------------------------

CREATE TABLE BUYER (
	ID					BIGSERIAL,
	NAME            		TEXT				NOT NULL,
	CODE            		TEXT				NOT NULL,
	ADDRESS_ID			BIGINT,
	PHONE           		BIGINT,
	REFERENCE_1			TEXT,
	REFERENCE_2			TEXT,
	REFERENCE_3			TEXT,
	ACTIVE				BOOLEAN			NOT NULL,
	CREATED_USER			TEXT				NOT NULL,
	CREATED_TS			TIMESTAMP		NOT NULL,
	MODIFIED_USER		TEXT				NOT NULL,
	MODIFIED_TS			TIMESTAMP		NOT NULL,
	PRIMARY KEY         (ID),
	FOREIGN KEY     		(ADDRESS_ID)		REFERENCES ADDRESS (ID)
);

CREATE TRIGGER BUYER_BIT
	BEFORE INSERT OR UPDATE ON BUYER
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: INVOICE
---------------------------------------------------------------------------

CREATE TABLE INVOICE (
	ID					BIGSERIAL,
	TRADER_ID			BIGINT			NOT NULL,
	TOTAL_TAX			DECIMAL(12,2)	NOT NULL,
	TOTAL_PRICE			DECIMAL(12,2)	NOT NULL,
	BUYER_ID				BIGINT,
	PHONE				BIGINT,
	ACTIVE				BOOLEAN			NOT NULL,
	CREATED_USER			TEXT				NOT NULL,
	CREATED_TS			TIMESTAMP		NOT NULL,
	MODIFIED_USER		TEXT				NOT NULL,
	MODIFIED_TS			TIMESTAMP		NOT NULL,
	PRIMARY KEY			(ID),
	FOREIGN KEY			(TRADER_ID)		REFERENCES TRADER (ID),
	FOREIGN KEY			(BUYER_ID)		REFERENCES BUYER (ID)
);
	
CREATE TRIGGER INVOICE_BIT
	BEFORE INSERT OR UPDATE ON INVOICE
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: LINE_ITEM
---------------------------------------------------------------------------

CREATE TABLE LINE_ITEM (
	ID      				BIGSERIAL,
	INVOICE_ID        	BIGINT			NOT NULL,
	ITEM_ID				BIGINT			NOT NULL,
 	QUANTITY				INTEGER			NOT NULL,
	TOTAL_TAX			DECIMAL(12,2)	NOT NULL,
	TOTAL_PRICE			DECIMAL(12,2)	NOT NULL,
	--TOTAL_CGST			DECIMAL(12,2)	NOT NULL,
	--TOTAL_SGST			DECIMAL(12,2)	NOT NULL,
	ACTIVE            	BOOLEAN			NOT NULL,
	CREATED_USER      	TEXT				NOT NULL,
	CREATED_TS        	TIMESTAMP		NOT NULL,
	MODIFIED_USER     	TEXT				NOT NULL,
	MODIFIED_TS       	TIMESTAMP		NOT NULL,
	PRIMARY KEY       	(ID),
	FOREIGN KEY       	(INVOICE_ID)    REFERENCES INVOICE (ID),
	FOREIGN KEY       	(ITEM_ID)       REFERENCES ITEM (ID)
);
	
CREATE TRIGGER LINE_ITEM_BIT
	BEFORE INSERT OR UPDATE ON LINE_ITEM
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: STOCK
---------------------------------------------------------------------------

CREATE TABLE STOCK (
	ID              	BIGSERIAL,
  	ITEM_ID         	BIGINT      	NOT NULL,
  	QUANTITY			INTEGER     	NOT NULL,
  	ACTIVE          	BOOLEAN     	NOT NULL,
  	CREATED_USER    	TEXT        	NOT NULL,
  	CREATED_TS      	TIMESTAMP   	NOT NULL,
  	MODIFIED_USER   	TEXT        	NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   	NOT NULL,
  	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(ITEM_ID)	REFERENCES ITEM (ID)
);
	
CREATE TRIGGER STOCK_BIT
	BEFORE INSERT OR UPDATE ON STOCK
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: STOCK_BATCH
---------------------------------------------------------------------------

CREATE TABLE STOCK_BATCH (
  	ID              	BIGSERIAL,
	TRADER_ID     	BIGINT      NOT NULL,
  	ACTIVE          	BOOLEAN     	NOT NULL,
  	CREATED_USER    	TEXT        	NOT NULL,
  	CREATED_TS      	TIMESTAMP   	NOT NULL,
  	MODIFIED_USER   	TEXT        	NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   	NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(TRADER_ID)	REFERENCES TRADER (ID)
);
	
CREATE TRIGGER STOCK_BATCH_BIT
	BEFORE INSERT OR UPDATE ON STOCK_BATCH
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: VENDOR
---------------------------------------------------------------------------

CREATE TABLE VENDOR (
  	ID              	BIGSERIAL,
  	NAME            	TEXT        	NOT NULL,
  	CODE				TEXT        	NOT NULL,
	ADDRESS_ID		BIGINT,
  	PHONE           	BIGINT      	NOT NULL,
	TRADER_ID     	BIGINT      NOT NULL,
  	ACTIVE          	BOOLEAN     	NOT NULL,
  	CREATED_USER    	TEXT        	NOT NULL,
  	CREATED_TS      	TIMESTAMP   	NOT NULL,
  	MODIFIED_USER   	TEXT        	NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   	NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     (ADDRESS_ID)	REFERENCES ADDRESS (ID),
	FOREIGN KEY     	(TRADER_ID)	REFERENCES TRADER (ID)
);
	
CREATE TRIGGER VENDOR_BIT
	BEFORE INSERT OR UPDATE ON VENDOR
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: STOCK_HISTORY
---------------------------------------------------------------------------

CREATE TABLE STOCK_HISTORY (
  	ID              	BIGSERIAL,
	STOCK_BATCH_ID	BIGINT      			NOT NULL,
	ITEM_ID         	BIGINT      			NOT NULL,
	VENDOR_ID		BIGINT      			NOT NULL,
	BASE_PRICE		DECIMAL(12,2)		NOT NULL,
	QUANTITY			INTEGER     			NOT NULL,
	ACTIVE          	BOOLEAN     			NOT NULL,
	CREATED_USER    	TEXT        			NOT NULL,
	CREATED_TS      	TIMESTAMP   			NOT NULL,
	MODIFIED_USER   	TEXT        			NOT NULL,
	MODIFIED_TS     	TIMESTAMP   			NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(STOCK_BATCH_ID)		REFERENCES STOCK_BATCH (ID),
	FOREIGN KEY     	(ITEM_ID)  			REFERENCES ITEM (ID),
	FOREIGN KEY     	(VENDOR_ID)	 		REFERENCES VENDOR (ID)
);
	
CREATE TRIGGER STOCK_HISTORY_BIT
	BEFORE INSERT OR UPDATE ON STOCK_HISTORY
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



---------------------------------------------------------------------------
--						TABLE: USERS
---------------------------------------------------------------------------

CREATE TABLE USERS (
	ID              	BIGSERIAL,
	NAME				TEXT			NOT NULL,
	USER_NAME		TEXT			NOT NULL,
	PASSWORD			TEXT			NOT NULL,
	TRADER_ID     	BIGINT      NOT NULL,
	LAST_LOGIN		TIMESTAMP,
	ACTIVE          	BOOLEAN     NOT NULL,
	CREATED_USER    	TEXT        NOT NULL,
	CREATED_TS      	TIMESTAMP   NOT NULL,
	MODIFIED_USER   	TEXT        NOT NULL,
	MODIFIED_TS     	TIMESTAMP   NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(TRADER_ID)	REFERENCES TRADER (ID)
);

CREATE TRIGGER USERS_BIT
	BEFORE INSERT OR UPDATE ON USERS
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();


CREATE TABLE EMPLOYEE (
	ID              	BIGSERIAL,
	NAME				TEXT			NOT NULL,
	ROLE				TEXT			NOT NULL,
	MANAGER_ID     	BIGINT
	);
	
INSERT INTO EMPLOYEE (NAME, ROLE) VALUES ('Robert Johnson', 'President');
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Oliver Twist', 'CEO', 1);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('John Twist', 'CFO', 1);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Martin Twist', 'COO', 1);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Fran Twist', 'CSO', 1);

INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Ram Mano', 'SVP', 2);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Suresh Mano', 'SVP', 2);

INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Andrew Robert', 'VP', 6);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Ruks Jamison', 'VP', 7);

INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Neha Raj', 'PM', 8);

INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Syam Raj', 'PM', 9);

INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Pankaj Thakur', 'TEAM LEAD', 10);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Dharmesh Patel', 'SENIOR SOFTWARE ENGINEER', 12);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Jyothi Krishnamani', 'SOFTWARE ENGINEER', 12);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Raj Kumar', 'JUNIOR SOFTWARE ENGINEER', 13);
INSERT INTO EMPLOYEE (NAME, ROLE, MANAGER_ID) VALUES ('Nilesh Gupta', 'TECHNICAL LEAD', 11);

DROP TABLE EMPLOYEE;


SELECT E.NAME, E.ROLE, M.ROLE
FROM EMPLOYEE M, EMPLOYEE E
WHERE M.ID = E.MANAGER_ID;