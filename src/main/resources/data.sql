

INSERT INTO TBL_GRP_PRODUCT (name) VALUES
                                             ('TELEPHONE'),
                                             ('PC'),
                                             ('MONITOR'),
                                             ('NOTEBOOK');

commit;


INSERT INTO TBL_PRODUCT (grp_product_id,name) VALUES
                                   (1,'APLE'),
                                   (1,'SAMSUNG'),
                                   (2,'HYPERPC'),
                                   (3,'ASUS'),
                                   (3,'SAMSUNG'),
                                   (3,'LOC'),
                                   (3,'DELL'),
                                   (4,'ASUS'),
                                   (4,'SAMSUNG')



;

commit;



SELECT * from TBL_PRODUCT;
SELECT * from TBL_GRP_PRODUCT;