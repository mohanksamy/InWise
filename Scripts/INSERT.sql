
INSERT INTO STORE(ID, NAME, ADDRESS, UIN, PHONE, ACTIVE, CREATED_USER, CREATED_TS, MODIFIED_USER, MODIFIED_TS)
VALUES(12345, 'VELSTORES', 'BALEPET, BANGALORE', 'TN34376936', 9448107287, TRUE, 'APP-SERVICES', NOW(), 'APP-SERVICES', NOW());


INSERT INTO TAX(ID, CGST, SGST, STORE_ID, ACTIVE, CREATED_USER, CREATED_TS, MODIFIED_USER, MODIFIED_TS)
VALUES(31213, 2.5, 2.5, 12345, TRUE, 'APP-SERVICES', NOW(), 'APP-SERVICES', NOW());
