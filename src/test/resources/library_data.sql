INSERT INTO LIBRARY_SCHEMA.LIBRARY_CARD(CARD_ID, START_DATE, EXPIRATION_DATE) VALUES
(1, TIMESTAMP '2013-04-15 06:16:41.313', TIMESTAMP '2014-04-15 06:16:41.313'),
(2, TIMESTAMP '2013-04-15 06:17:06.154', TIMESTAMP '2014-04-15 06:17:06.154'),
(3, TIMESTAMP '2013-04-15 06:17:30.593', TIMESTAMP '2014-04-15 06:17:30.593');
INSERT INTO LIBRARY_SCHEMA.USERS(USER_ID, FIRSTNAME, LASTNAME, EMAIL, CARD_ID) VALUES
(1, 'Fred', 'Flintstone', 'fflintstone@bedrock.com', 1),
(2, 'Barney', 'Rubble', 'brubble@rubble.net', 2),
(3, 'Pebbles', 'Flintstone', 'pebbles.flintstone@stones.net', 3);
