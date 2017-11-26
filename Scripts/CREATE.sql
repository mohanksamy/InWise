
CREATE TABLE STORES (
  ID            BIGINT    NOT NULL,
  NAME          TEXT      NOT NULL,
  ADDRESS       TEXT      NOT NULL,
  UIN           TEXT      NOT NULL,
  PHONE         BIGINT    NOT NULL,
  ACTIVE        BOOLEAN   NOT NULL,
  CREATED_USER  TEXT      NOT NULL,
  CREATED_TS    TIMESTAMP NOT NULL,
  MODIFIED_USER TEXT      NOT NULL,
  MODIFIED_TS   TIMESTAMP NOT NULL,
  PRIMARY KEY   (ID) );

CREATE TYPE CATEGORY AS ENUM ('INNERS', 'FANCY DRESS');

CREATE TYPE TYPE AS ENUM ('MEN VESTS', 'BABY');

CREATE TABLE TAX (
  ID            BIGINT    NOT NULL,
  CGST          FLOAT     NOT NULL,
  SGST          FLOAT     NOT NULL,
  STORE_ID      BIGINT    NOT NULL,
  ACTIVE        BOOLEAN   NOT NULL,
  CREATED_USER  TEXT      NOT NULL,
  CREATED_TS    TIMESTAMP NOT NULL,
  MODIFIED_USER TEXT      NOT NULL,
  MODIFIED_TS   TIMESTAMP NOT NULL,
  PRIMARY KEY   (ID),
  FOREIGN KEY   (STORE_ID) REFERENCES STORES (ID));

CREATE TABLE ITEMS (
  ID            BIGINT    NOT NULL,
  NAME          TEXT      NOT NULL,
  PART_NO       BIGINT,
  PRICE         FLOAT     NOT NULL,
  HSN_SAC       TEXT,
  STORE_ID      BIGINT    NOT NULL,
  CATEGORY      CATEGORY,
  TYPE          TYPE,
  TAX_ID        BIGINT    NOT NULL,
  ACTIVE        BOOLEAN   NOT NULL,
  CREATED_USER  TEXT      NOT NULL,
  CREATED_TS    TIMESTAMP NOT NULL,
  MODIFIED_USER TEXT      NOT NULL,
  MODIFIED_TS   TIMESTAMP NOT NULL,
  PRIMARY KEY   (ID),
  FOREIGN KEY   (STORE_ID) REFERENCES STORES (ID),
  FOREIGN KEY   (TAX_ID) REFERENCES TAX (ID));



CREATE TABLE INVOICE (
  ID                        BIGINT    NOT NULL,
  STORE_ID                  BIGINT    NOT NULL,
  ITEM_ID                   BIGINT    NOT NULL,
  ITEM_QUANTITY             SMALLINT,
  CGST                      FLOAT     NOT NULL,
  SGST                      FLOAT     NOT NULL,
  BUYER_NAME                TEXT,
  DESPATCHED_THROUGH        TEXT,
  DESPATCHED_DOCUMENT_NO    TEXT,
  DESTINATION               TEXT,
  MODE_OR_TERMS_OF_PAYMENT  TEXT,
  SUPPLIER_REFERENCE        TEXT,
  ACTIVE        BOOLEAN   NOT NULL,
  CREATED_USER  TEXT      NOT NULL,
  CREATED_TS    TIMESTAMP NOT NULL,
  MODIFIED_USER TEXT      NOT NULL,
  MODIFIED_TS   TIMESTAMP NOT NULL,
  PRIMARY KEY   (ID),
  FOREIGN KEY   (STORE_ID) REFERENCES STORES (ID),
  FOREIGN KEY   (ITEM_ID) REFERENCES ITEMS (ID));
