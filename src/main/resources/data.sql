INSERT INTO addresses (address, city, postal_code ) VALUES
	('Krzesinka 117', 'Poznań', '61-324');
INSERT INTO authors (address_id, first_name, last_name) VALUES
	((SELECT LAST_INSERT_ID()), 'Róża', 'Zając');
  
INSERT INTO addresses (address, city, postal_code ) VALUES
    ('Rondo Kujawskie 4', 'Bydgoszcz', '85-146');
INSERT INTO authors (address_id, first_name, last_name) VALUES
    ((SELECT LAST_INSERT_ID()), 'Szymon', 'Woźniak');
    
INSERT INTO addresses (address, city, postal_code ) VALUES
    ('Traktorowa 71', 'Łódź', '91-144');
INSERT INTO authors (address_id, first_name, last_name) VALUES   
    ((SELECT LAST_INSERT_ID()), 'Ruta', 'Kaczmarek');
    
INSERT INTO addresses (address, city, postal_code ) VALUES
    ('Kamienne Schodki 144', 'Będzin', '42-500');
INSERT INTO authors (address_id, first_name, last_name) VALUES
    ((SELECT LAST_INSERT_ID()), 'Wisława', 'Duda');
    
INSERT INTO addresses (address, city, postal_code ) VALUES
    ('Matki Teresy z Kalkuty 87', 'Szczecin', '71-622');
INSERT INTO authors (address_id, first_name, last_name) VALUES   
    ((SELECT LAST_INSERT_ID()), 'Gertruda', 'Wojciechowska');


INSERT INTO addresses (address, city, postal_code ) VALUES
	('Traktorowa 71', 'Łódź', '91-144');
INSERT INTO users (address_id, first_name, last_name, gender, e_mail, phone_no) VALUES
    ((SELECT LAST_INSERT_ID()), 'Krystiana', 'Majewska', 'female', 'KrystianaMajewska@teleworm.us','67 826 63 45');

INSERT INTO addresses (address, city, postal_code ) VALUES
	('Krecia 127', 'Łódź', '91-510');
INSERT INTO users (address_id, first_name, last_name, gender, e_mail, phone_no) VALUES
    ((SELECT LAST_INSERT_ID()), 'Radomił', 'Kalinowski', 'male', 'RadomilKalinowski@rhyta.com','51 764 25 42');

INSERT INTO addresses (address, city, postal_code ) VALUES
	('Mokra 8', 'Zielona Góra', '65-384');
INSERT INTO users (address_id, first_name, last_name, gender, e_mail, phone_no) VALUES
    ((SELECT LAST_INSERT_ID()), 'Zofia', 'Michalska', 'female', 'ZofiaMichalska@teleworm.us','503 221 145');
    
INSERT INTO addresses (address, city, postal_code ) VALUES
	('Judyma 131', 'Kędzierzyn-Koźle', '47-220');
INSERT INTO users (address_id, first_name, last_name, gender, e_mail, phone_no) VALUES
    ((SELECT LAST_INSERT_ID()), 'Władysław', 'Olszewski', 'male', 'WladyslawOlszewski@armyspy.com','607 761 566');
    
INSERT INTO addresses (address, city, postal_code ) VALUES
	('Jabłoniowa 129', 'Szczecin', '70-761');
INSERT INTO users (address_id, first_name, last_name, gender, e_mail, phone_no) VALUES
    ((SELECT LAST_INSERT_ID()), 'Stanisław', 'Jabłoński', 'male', 'StanislawJablonski@google.com','606 667 221');
    
INSERT INTO addresses (address, city, postal_code ) VALUES
	('Migdałowa 86', 'Poznań', '61-612');
INSERT INTO users (address_id, first_name, last_name, gender, e_mail, phone_no) VALUES
    ((SELECT LAST_INSERT_ID()), 'Ela', 'Zając', 'female', 'ElaZajac@dayrep.com','605 828 227');
    
 
INSERT INTO addresses (address, city, postal_code ) VALUES
	('Belwederczyków 110', 'Kraków', '31-242');
INSERT INTO libraries (address_id, lib_name) VALUES
    ((SELECT LAST_INSERT_ID()), 'Biblioteka Miejska nr 23');   
    
INSERT INTO addresses (address, city, postal_code ) VALUES
	('Starościńska 27', 'Warszawa', '02-516');
INSERT INTO libraries (address_id, lib_name) VALUES
    ((SELECT LAST_INSERT_ID()), 'Biblioteka Narodowa');
    
INSERT INTO addresses (address, city, postal_code ) VALUES
	('Pucka 47', 'Wrocław', '54-312');
INSERT INTO libraries (address_id, lib_name) VALUES
    ((SELECT LAST_INSERT_ID()), 'Biblioteka Interdyscyplinarna');


INSERT INTO categories (category_name) VALUES
	('Biografia'),
    ('Fantastyka'),
    ('Kryminał'),
    ('Horror'),
    ('Historia');

INSERT INTO books (isbn, author_id, title, publish_date) VALUES 
    ('12345678900',(SELECT id FROM authors WHERE first_name = 'Ruta' AND last_name = 'Kaczmarek'),
    'Przygody Waleriana',
    '2003-12-31');

INSERT INTO books (isbn, author_id, title, publish_date) VALUES 
    ('92345678104',(SELECT id FROM authors WHERE first_name = 'Ruta' AND last_name = 'Kaczmarek'),
    'Ona i Ja',
    '1997-07-22');
    
INSERT INTO books (isbn, author_id, title, publish_date) VALUES 
    ('52345338214',(SELECT id FROM authors WHERE first_name = 'Wisława' AND last_name = 'Duda'),
    'Spalona Ziemia',
    '2006-01-24');
    
INSERT INTO books (isbn, author_id, title, publish_date) VALUES 
    ('42345373222',(SELECT id FROM authors WHERE first_name = 'Wisława' AND last_name = 'Duda'),
    'Rewizja zwyczajna',
    '2002-08-03');
    
INSERT INTO books (isbn, author_id, title, publish_date) VALUES 
    ('15723374782',(SELECT id FROM authors WHERE first_name = 'Szymon' AND last_name = 'Woźniak'),
    'Sekretne życie Maggi',
    '2002-04-11');
    
INSERT INTO books (isbn, author_id, title, publish_date) VALUES 
    ('33227148920',(SELECT id FROM authors WHERE first_name = 'Szymon' AND last_name = 'Woźniak'),
    'Dom i jego mieszkańcy',
    '2002-03-17');
    
INSERT INTO books (isbn, author_id, title, publish_date) VALUES 
    ('34784381220',(SELECT id FROM authors WHERE first_name = 'Róża' AND last_name = 'Zając'),
    'Pax votum',
    '1998-9-21');
    
INSERT INTO books (isbn, author_id, title, publish_date) VALUES 
    ('86017277220',(SELECT id FROM authors WHERE first_name = 'Róża' AND last_name = 'Zając'),
    'Schronienie',
    '2001-07-06');
    

INSERT INTO books_at_libraries (isbn, library_id) VALUES
	((SELECT isbn FROM books WHERE title = 'Pax votum'), 1),
    ((SELECT isbn FROM books WHERE title = 'Rewizja Zwyczajna'), 1),
    ((SELECT isbn FROM books WHERE title = 'Sekretne życie Maggi'), 1),
    ((SELECT isbn FROM books WHERE title = 'Ona i Ja'), 2),
    ((SELECT isbn FROM books WHERE title = 'Spalona Ziemia'), 2),
    ((SELECT isbn FROM books WHERE title = 'Dom i jego mieszkańcy'), 3),
    ((SELECT isbn FROM books WHERE title = 'Przygody Waleriana'), 3);
    
    
INSERT INTO books_at_categories (isbn, category_id) VALUES
	((SELECT isbn FROM books WHERE title = 'Przygody Waleriana'), 2),
    ((SELECT isbn FROM books WHERE title = 'Przygody Waleriana'), 4),
    ((SELECT isbn FROM books WHERE title = 'Pax votum'), 1),
    ((SELECT isbn FROM books WHERE title = 'Pax votum'), 3),
    ((SELECT isbn FROM books WHERE title = 'Pax votum'), 5),
    ((SELECT isbn FROM books WHERE title = 'Rewizja Zwyczajna'), 2),
    ((SELECT isbn FROM books WHERE title = 'Sekretne życie Maggi'), 1),
    ((SELECT isbn FROM books WHERE title = 'Sekretne życie Maggi'), 5),
    ((SELECT isbn FROM books WHERE title = 'Ona i Ja'), 1),
    ((SELECT isbn FROM books WHERE title = 'Ona i Ja'), 3),
    ((SELECT isbn FROM books WHERE title = 'Spalona Ziemia'), 1),
    ((SELECT isbn FROM books WHERE title = 'Spalona Ziemia'), 3),
    ((SELECT isbn FROM books WHERE title = 'Spalona Ziemia'), 5),
    ((SELECT isbn FROM books WHERE title = 'Dom i jego mieszkańcy'), 2),
    ((SELECT isbn FROM books WHERE title = 'Dom i jego mieszkańcy'), 4);
    
    INSERT INTO books_at_users (isbn, user_id) VALUES
	((SELECT isbn FROM books WHERE title = 'Przygody Waleriana'), 1),
    ((SELECT isbn FROM books WHERE title = 'Przygody Waleriana'), 2),
    ((SELECT isbn FROM books WHERE title = 'Przygody Waleriana'), 3),
    ((SELECT isbn FROM books WHERE title = 'Przygody Waleriana'), 4),
    ((SELECT isbn FROM books WHERE title = 'Pax votum'), 2),
    ((SELECT isbn FROM books WHERE title = 'Pax votum'), 3),
    ((SELECT isbn FROM books WHERE title = 'Pax votum'), 5),
    ((SELECT isbn FROM books WHERE title = 'Rewizja Zwyczajna'), 2),
    ((SELECT isbn FROM books WHERE title = 'Rewizja Zwyczajna'), 3),
    ((SELECT isbn FROM books WHERE title = 'Rewizja Zwyczajna'), 4),
    ((SELECT isbn FROM books WHERE title = 'Rewizja Zwyczajna'), 5),
    ((SELECT isbn FROM books WHERE title = 'Sekretne życie Maggi'), 6),
    ((SELECT isbn FROM books WHERE title = 'Sekretne życie Maggi'), 5),
    ((SELECT isbn FROM books WHERE title = 'Sekretne życie Maggi'), 4),
    ((SELECT isbn FROM books WHERE title = 'Ona i Ja'), 1),
    ((SELECT isbn FROM books WHERE title = 'Ona i Ja'), 3),
    ((SELECT isbn FROM books WHERE title = 'Ona i Ja'), 5),
    ((SELECT isbn FROM books WHERE title = 'Spalona Ziemia'), 3),
    ((SELECT isbn FROM books WHERE title = 'Spalona Ziemia'), 4),
    ((SELECT isbn FROM books WHERE title = 'Spalona Ziemia'), 5),
    ((SELECT isbn FROM books WHERE title = 'Dom i jego mieszkańcy'), 2),
    ((SELECT isbn FROM books WHERE title = 'Dom i jego mieszkańcy'), 4),
    ((SELECT isbn FROM books WHERE title = 'Dom i jego mieszkańcy'), 5),
    ((SELECT isbn FROM books WHERE title = 'Dom i jego mieszkańcy'), 6);
    

    
    