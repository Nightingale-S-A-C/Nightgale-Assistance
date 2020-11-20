INSERT INTO USERS(EMAIL, NAME, PASSWORD, ROLE) VALUES('Chorri777@gmail.com','Juan Costa Jose Maria', 'coco', 'Admin');
INSERT INTO USERS(EMAIL, NAME, PASSWORD, ROLE) VALUES('Protoxxx@gmail.com','Adrian Gabriel Suarez', 'coca','Admin');
INSERT INTO USERS(EMAIL, NAME, PASSWORD, ROLE) VALUES('CarlosUpa@gmail.com','Carlos Iparraguirre', 'cucu','Admin');
INSERT INTO USERS(EMAIL, NAME, PASSWORD, ROLE) VALUES('sos@gmail.com','Hernan Razo', 'cici','Cliente');





INSERT INTO PRODUCTS(CATEGORY, DESCRIPTION, NAME, PRICE, STOCK) VALUES('Traje_Anti_Fluido', 'a', 'd', 80, 5);
INSERT INTO PRODUCTS(CATEGORY, DESCRIPTION, NAME, PRICE, STOCK) VALUES('Protector_Facial', 'Mascara de protección facial', 'Hecho de policarbonato transparente', 10.0, 3);
INSERT INTO PRODUCTS(CATEGORY, DESCRIPTION, NAME, PRICE, STOCK) VALUES('Mascarilla', 'Cubrebocas de tela color azul', 'Mascarilla Levi', 30.0, 6);
INSERT INTO PRODUCTS(CATEGORY, DESCRIPTION, NAME, PRICE, STOCK) VALUES('Mascarilla', 'Cubrebocas unisex de algodon elastico con franja y logo', 'Mascarilla Hugo Boss', 50.0, 6);


INSERT INTO ORDERS(STATUS, PAYMENT, REG_DATE, TOTAL) VALUES (TRUE , 'TARJETA', now(), 90);
INSERT INTO ORDER_LINES(ORDER_ID, PRODUCT_ID, PRICE, QUANTITY, TOTAL) VALUES (1, 1, 80, 1, 80);
INSERT INTO ORDER_LINES(ORDER_ID, PRODUCT_ID, PRICE, QUANTITY, TOTAL) VALUES (1, 2, 10, 1, 10);

