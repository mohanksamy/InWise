
-- ENUM TYPES

CREATE TYPE BRAND AS ENUM ('POOMER', 'POOMEX', 'GRS', 'EFRESH');

CREATE TYPE CATEGORY AS ENUM ('MENS', 'WOMENS', 'BOYS', 'GIRLS', 'BABY_BOYS', 'BABY_GIRLS', 'INFANTS');

CREATE TYPE SUB_CATEGORY AS ENUM ('INNERS', 'OUTFITTINGS', 'TOP', 'BOTTOM', 'FROCK');

CREATE TYPE SIZE AS ENUM ('S_30', 'S_35', 'S_40', 'S_45', 'S_50', 'S_55', 'S_60', 'S_65', 'S_70', 'S_75', 'S', 'M', 'L', 'XL', 'XXL', 'NA');



CREATE OR REPLACE FUNCTION TRIGGER_FN()
RETURNS trigger AS '
	BEGIN
		IF TG_OP = ''INSERT'' THEN
			NEW.CREATED_TS := NOW();
			NEW.MODIFIED_TS := NOW();
		ELSIF TG_OP = ''UPDATE'' THEN
			NEW.CREATED_TS := OLD.CREATED_TS;
			NEW.MODIFIED_TS := NOW();
		END IF; 
		
		RETURN NEW;
	END'
LANGUAGE 'plpgsql';



CREATE TABLE STORE (
	ID              	BIGINT      NOT NULL,
  	NAME            	TEXT        NOT NULL,
 	ADDRESS         	TEXT        NOT NULL,
  	UIN             	TEXT        NOT NULL,
  	PHONE           	BIGINT      NOT NULL,
  	ACTIVE          	BOOLEAN     NOT NULL,
  	CREATED_USER    	TEXT        NOT NULL,
  	CREATED_TS      	TIMESTAMP   NOT NULL,
  	MODIFIED_USER   	TEXT        NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   NOT NULL,
  	PRIMARY KEY     	(ID)
);

CREATE SEQUENCE IF NOT EXISTS STORE_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY STORE.ID;

CREATE TRIGGER STORE_BIT
	BEFORE INSERT OR UPDATE ON STORE 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



CREATE TABLE TAX (
  	ID              	BIGINT      NOT NULL,
  	CGST            	FLOAT       NOT NULL,
 	SGST            	FLOAT       NOT NULL,
	STORE_ID        	BIGINT      NOT NULL,
	ACTIVE          	BOOLEAN     NOT NULL,
	CREATED_USER    	TEXT        NOT NULL,
	CREATED_TS      	TIMESTAMP   NOT NULL,
	MODIFIED_USER   	TEXT        NOT NULL,
	MODIFIED_TS     	TIMESTAMP   NOT NULL,
	PRIMARY KEY     	(ID),
	FOREIGN KEY     	(STORE_ID)  REFERENCES STORE (ID)
);

CREATE SEQUENCE IF NOT EXISTS TAX_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY TAX.ID;

CREATE TRIGGER TAX_BIT
	BEFORE INSERT OR UPDATE ON TAX 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



CREATE TABLE ITEM (
	ID              	BIGINT      NOT NULL,
	NAME            	TEXT        NOT NULL,
	PART_NO         	BIGINT,
	PRICE           	FLOAT       NOT NULL,
	HSN_SAC         	TEXT,
  	CATEGORY        	CATEGORY,
  	SUB_CATEGORY    	SUB_CATEGORY,
  	BRAND    		BRAND,
  	SIZE            	SIZE,
  	STORE_ID        	BIGINT      NOT NULL,
  	TAX_ID          	BIGINT      NOT NULL,
  	ACTIVE          	BOOLEAN     NOT NULL,
  	CREATED_USER    	TEXT        NOT NULL,
  	CREATED_TS      	TIMESTAMP   NOT NULL,
  	MODIFIED_USER   	TEXT        NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   NOT NULL,
  	PRIMARY KEY     	(ID),
  	FOREIGN KEY     	(STORE_ID)  REFERENCES STORE (ID),
  	FOREIGN KEY     	(TAX_ID)    REFERENCES TAX (ID)
);

CREATE SEQUENCE IF NOT EXISTS ITEM_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY ITEM.ID;
	
CREATE TRIGGER ITEM_BIT
	BEFORE INSERT OR UPDATE ON ITEM 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



CREATE TABLE INVOICE (
	ID                          BIGINT    NOT NULL,
  	STORE_ID                    BIGINT    NOT NULL,
  	TOTAL_TAX          			FLOAT     NOT NULL,
	TOTAL_PRICE         			FLOAT     NOT NULL,
  	BUYER_NAME                  TEXT,
  	DESPATCHED_THROUGH          TEXT,
  	DESPATCHED_DOCUMENT_NO      TEXT,
  	DESTINATION                 TEXT,
  	MODE_OR_TERMS_OF_PAYMENT    TEXT,
  	SUPPLIER_REFERENCE          TEXT,
  	ACTIVE                      BOOLEAN     NOT NULL,
  	CREATED_USER                TEXT        NOT NULL,
  	CREATED_TS                  TIMESTAMP   NOT NULL,
  	MODIFIED_USER               TEXT        NOT NULL,
  	MODIFIED_TS                 TIMESTAMP   NOT NULL,
  	PRIMARY KEY                 (ID),
  	FOREIGN KEY                 (STORE_ID)  REFERENCES STORE (ID)
);

CREATE SEQUENCE IF NOT EXISTS INVOICE_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY INVOICE.ID;
	
CREATE TRIGGER INVOICE_BIT
	BEFORE INSERT OR UPDATE ON INVOICE 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



CREATE TABLE LINE_ITEM (
	LINE_ITEM_ID      	BIGINT          NOT NULL,
	INVOICE_ID        	BIGINT          NOT NULL,
	ITEM_ID           	BIGINT          NOT NULL,
 	QUANTITY				INTEGER     		NOT NULL,
 	TOTAL_TAX           FLOAT     		NOT NULL,
	TOTAL_PRICE         FLOAT     		NOT NULL,
	--TOTAL_CGST        FLOAT     		NOT NULL,
	--TOTAL_SGST        FLOAT     		NOT NULL,
	ACTIVE            	BOOLEAN         NOT NULL,
	CREATED_USER      	TEXT            NOT NULL,
	CREATED_TS        	TIMESTAMP       NOT NULL,
	MODIFIED_USER     	TEXT            NOT NULL,
	MODIFIED_TS       	TIMESTAMP       NOT NULL,
	PRIMARY KEY       	(LINE_ITEM_ID),
	FOREIGN KEY       	(INVOICE_ID)    REFERENCES INVOICE (ID),
	FOREIGN KEY       	(ITEM_ID)       REFERENCES ITEM (ID)
);

CREATE SEQUENCE IF NOT EXISTS LINE_ITEM_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY LINE_ITEM.LINE_ITEM_ID;
	
CREATE TRIGGER LINE_ITEM_BIT
	BEFORE INSERT OR UPDATE ON LINE_ITEM 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



CREATE TABLE STOCK (
	ID              	BIGINT      	NOT NULL,
  	ITEM_ID         	BIGINT      	NOT NULL,
  	QUANTITY			INTEGER     	NOT NULL,
  	ACTIVE          	BOOLEAN     	NOT NULL,
  	CREATED_USER    	TEXT        	NOT NULL,
  	CREATED_TS      	TIMESTAMP   	NOT NULL,
  	MODIFIED_USER   	TEXT        	NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   	NOT NULL,
  	PRIMARY KEY     	(ID),
  	FOREIGN KEY     	(ITEM_ID)  		REFERENCES ITEM (ID)
);

CREATE SEQUENCE IF NOT EXISTS STOCK_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY STOCK.ID;
	
CREATE TRIGGER STOCK_BIT
	BEFORE INSERT OR UPDATE ON STOCK 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



CREATE TABLE STOCK_BATCH (
  	ID              	BIGINT      	NOT NULL,
  	ACTIVE          	BOOLEAN     	NOT NULL,
  	CREATED_USER    	TEXT        	NOT NULL,
  	CREATED_TS      	TIMESTAMP   	NOT NULL,
  	MODIFIED_USER   	TEXT        	NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   	NOT NULL,
  	PRIMARY KEY     	(ID)
);

CREATE SEQUENCE IF NOT EXISTS STOCK_BATCH_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY STOCK_BATCH.ID;
	
CREATE TRIGGER STOCK_BATCH_BIT
	BEFORE INSERT OR UPDATE ON STOCK_BATCH 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



CREATE TABLE VENDOR (
  	ID              	BIGINT      	NOT NULL,
  	NAME            	TEXT        	NOT NULL,
  	CODE				TEXT        	NOT NULL,
  	ADDRESS         	TEXT        	NOT NULL,
  	PHONE           	BIGINT      	NOT NULL,
  	ACTIVE          	BOOLEAN     	NOT NULL,
  	CREATED_USER    	TEXT        	NOT NULL,
  	CREATED_TS      	TIMESTAMP   	NOT NULL,
  	MODIFIED_USER   	TEXT        	NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   	NOT NULL,
  	PRIMARY KEY     	(ID)
);

CREATE SEQUENCE IF NOT EXISTS VENDOR_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY VENDOR.ID;
	
CREATE TRIGGER VENDOR_BIT
	BEFORE INSERT OR UPDATE ON VENDOR 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();



CREATE TABLE STOCK_HISTORY (
  	ID              	BIGINT      	NOT NULL,
  	STOCK_BATCH_ID	BIGINT      	NOT NULL,
  	ITEM_ID         	BIGINT      	NOT NULL,
  	VENDOR_ID		BIGINT      	NOT NULL,
  	BASE_PRICE      FLOAT       	NOT NULL,
  	QUANTITY			INTEGER     	NOT NULL,
  	ACTIVE          	BOOLEAN     	NOT NULL,
  	CREATED_USER    	TEXT        	NOT NULL,
  	CREATED_TS      	TIMESTAMP   	NOT NULL,
  	MODIFIED_USER   	TEXT        	NOT NULL,
  	MODIFIED_TS     	TIMESTAMP   	NOT NULL,
  	PRIMARY KEY     	(ID),
  	FOREIGN KEY     	(STOCK_BATCH_ID)	REFERENCES STOCK_BATCH (ID),
  	FOREIGN KEY     	(ITEM_ID)  			REFERENCES ITEM (ID),
  	FOREIGN KEY     	(VENDOR_ID)	 		REFERENCES VENDOR (ID)
);

CREATE SEQUENCE IF NOT EXISTS STOCK_HISTORY_SEQ
	INCREMENT BY 1
	START WITH 1001 
	NO CYCLE
	OWNED BY STOCK_HISTORY.ID;
	
CREATE TRIGGER STOCK_HISTORY_BIT
	BEFORE INSERT OR UPDATE ON STOCK_HISTORY 
	FOR EACH ROW EXECUTE PROCEDURE TRIGGER_FN();