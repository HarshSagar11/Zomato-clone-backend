INSERT INTO wallet (balance) VALUES
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000),
    (1000);

INSERT INTO app_user (name, email, password, wallet_id, phone_number)
VALUES
    ('John Doe', 'john.doe@example.com', '$2a$10$iYJe3yGl0hlfmw8ENr6vl..FicbCZGDVaC2lN/tzC29dF9RJk94vC', 1, '9097652543'),
    ('Jane Smith', 'jane.smith@example.com', '$2a$10$V5v46PrgsInO5amlSMmrcOdjp2eo9nmuhHk.hY0jLz4oGql3AIoI6', 2, '9097652543'),
    ('Alice Johnson', 'alice.johnson@example.com', '$2a$10$9c9xiDYe/jT6Fj3PbsRxP.guI0yBD2UO9aTUxVjxfuo323EQSfQX6', 3, '9097652543'),
    ('Bob Brown', 'bob.brown@example.com', '$2a$10$x0MqShOAyK825P/hc2OooeBh0bWtdGn7OHGLRNnyWbFJTiSNaHHQm', 4, '9097652543'),
    ('Charlie White', 'charlie.white@example.com', '$2a$10$T.XB6A31JiefxNRdv9WfDe.Iz32wNTH2FPwvQNR8pCpstdEGOAOQK', 5, '9097652543'),
    ('Diana Green', 'diana.green@example.com', '$2a$10$CVaL3gXunSGz7SmshqCuEu6Fh.aJ8VtoMGePUMXsQMeGl2a5i.RtO', 6, '9097652543'),
    ('Eve Black', 'eve.black@example.com', '$2a$10$dWVmWfNwaBqkYlsU9JPCS.AC.b8W/K2iRq9jT/ZISYzuyPcFe4R9C', 7, '9097652543'),
    ('Frank Blue', 'frank.blue@example.com', '$2a$10$M61VvS7Q9ewyUWgIXj/A6u6wSeYbtWmEdfzRk.236dYsHLTl1uKDu', 8, '9097652543'),
    ('Grace Yellow', 'grace.yellow@example.com', '$2a$10$/ioP28/Zi2gilL9BukI5COe6WJ2o3XLNRpdD1h5JWkNFWp9hc5JNO', 9, '9097652543'),
    ('Henry Purple', 'henry.purple@example.com', '$2a$10$NDF0qLr.WuW5x9aoI5vkueHXStbCA3/BusNi3uQrHv/zHSEfqZztG', 10, '9097652543'),
    ('Ivy Brown', 'ivy.brown@example.com', '$2a$10$v4kOkOyDx2CvQ/LFBhQk7eerq.icCr/yybsRaRVLuDjxquZ0op6c6', 11, '9097652543'),
    ('Jack White', 'jack.white@example.com', '$2a$10$sL7CkGRMGr521eWXtQ/eFOGbPRyA9YOinN87VfO4bAGUKgCxVaRXK', 12, '9097652543'),
    ('Liam Gray', 'liam.gray@example.com', '$2a$10$eXShYZj/U1t7wSCsRiiptOzlSML9SFO9itG9iHvQIARCjiu5WPL4a', 13, '9097652543'),
    ('Mia Red', 'mia.red@example.com', '$2a$10$keFj1WWKTPzpZGDvhmbEEu631Uc97vdiisvbmtSd7iwf7JiBPpRla', 14, '9097652543');

INSERT INTO user_role (user_id, role) VALUES
(1, 'CUSTOMER'),
(2, 'ADMIN'),
(3, 'RESTAURANT_ADMIN'),
(4, 'RESTAURANT_ADMIN'),
(5, 'RESTAURANT_ADMIN'),
(6, 'RESTAURANT_ADMIN'),
(7, 'RESTAURANT_ADMIN'),
(8, 'RESTAURANT_ADMIN'),
(9, 'DELIVERY_PARTNER'),
(10, 'DELIVERY_PARTNER'),
(11, 'DELIVERY_PARTNER'),
(12, 'DELIVERY_PARTNER'),
(13, 'DELIVERY_PARTNER'),
(14, 'DELIVERY_PARTNER');

INSERT INTO admin (user_id) VALUES
(2);

INSERT INTO address (complete_address, coordinates) VALUES
('Sample Location 1', ST_GeomFromText('POINT(85.00484693864607 24.887359089198398)', 4326)),
('Sample Location 2', ST_GeomFromText('POINT(85.00356464644203 24.77541187094315)', 4326)),
('Sample Location 3', ST_GeomFromText('POINT(85.01154283452769 24.821605640069652)', 4326)),
('Sample Location 4', ST_GeomFromText('POINT(84.99454609086521 24.800374677294016)', 4326)),
('Sample Location 5', ST_GeomFromText('POINT(84.99369761908099 24.88102286913968)', 4326)),
('Sample Location 6', ST_GeomFromText('POINT(84.99033521452104 24.79647498875277)', 4326)),
('Sample Location 7', ST_GeomFromText('POINT(85.08287745337194 24.791636412625982)', 4326)),
('Sample Location 8', ST_GeomFromText('POINT(85.09123480451652 24.806523199302184)', 4326)),
('Sample Location 9', ST_GeomFromText('POINT(85.03027592366496 24.84434237910432)', 4326)),
('Sample Location 10', ST_GeomFromText('POINT(85.08463542934017 24.81065733901778)', 4326)),
('Sample Location 11', ST_GeomFromText('POINT(85.07154460177485 24.77420975056808)', 4326)),
('Sample Location 12', ST_GeomFromText('POINT(85.01337443105635 24.7288465569714)', 4326)),
('Sample Location 13', ST_GeomFromText('POINT(85.02189397324304 24.85761871768386)', 4326));

--INSERT INTO delivery_partner (user_id, aadhar_no, vehicle_no, is_available, admin_id, current_location, rating) VALUES
--(9, 1001, 'BR02-1111', true, 1, 13 , 4.9),
--(10, 1002, 'BR02-2222', true, 1, 10, 4.8),
--(11, 1003, 'BR02-3333', true, 1, 11, 4.7),
--(12, 1004, 'BR02-4444', true, 1, 12, 4.8),
--(13, 1005, 'BR02-5555', true, 1, 6, 4.6),
--(14, 1006, 'BR02-6666', true, 1, 3, 4.7);
INSERT INTO delivery_partner (user_id, aadhar_no, vehicle_no, is_available, admin_id, current_location, rating) VALUES
(9, 2001, 'BR03-1111', true, 1, ST_GeomFromText('POINT(84.99454609086521 24.800374677294016)', 4326), 4.9), -- center
(10, 2002, 'BR03-2222', true, 1, ST_GeomFromText('POINT(85.00454609086521 24.810374677294016)', 4326), 4.8), -- NE
(11, 2003, 'BR03-3333', true, 1, ST_GeomFromText('POINT(84.98454609086521 24.795374677294016)', 4326), 4.7), -- SW
(12, 2004, 'BR03-4444', true, 1, ST_GeomFromText('POINT(84.99954609086521 24.790374677294016)', 4326), 4.8), -- S
(13, 2005, 'BR03-5555', true, 1, ST_GeomFromText('POINT(85.00954609086521 24.805374677294016)', 4326), 4.6), -- E
(14, 2006, 'BR03-6666', true, 1, ST_GeomFromText('POINT(84.97954609086521 24.810374677294016)', 4326), 4.7); -- W

INSERT INTO restaurant ( name, description, restaurant_type, is_open, address_id, rating) VALUES
('Spice Delight', 'A popular restaurant offering a wide variety of Indian spices and curries.', 'VEG_AND_NON_VEG', true, 1, 4.6),
('Tandoori Flames', 'Authentic tandoori dishes with rich flavors.', 'NON_VEG', true, 2, 4.4),
('Ocean Grill', 'Seafood specialties with a coastal ambiance.', 'NON_VEG', true, 5, 4.3),
('Urban Tadka', 'A modern twist on traditional Indian flavors.', 'VEG_AND_NON_VEG', true, 7, 4.8),
('Street Spice', 'A casual eatery serving popular Indian street food.', 'VEG', true, 8, 4.2),
('Flavors of Punjab', 'North Indian cuisine with a variety of rich curries.', 'VEG_AND_NON_VEG', true, 9, 4.5);

INSERT INTO restaurant_admin (user_id, aadhar_no, admin_id, restaurant_id) VALUES
(3, 1111, 1, 1),
(4, 1112, 1, 2),
(5, 1113, 1, 3),
(6, 1114, 1, 4),
(7, 1115, 1, 5),
(8, 1116, 1, 6);

INSERT INTO menu (menu_name, restaurant_id, is_active) VALUES
('Indian Special', 1, true),
('Tandoori Platter', 1, true),
('Butter Chicken', 2, true),
('Paneer Tikka', 2, true),
('Vegan Delight', 3, true),
('Organic Salad', 3, true),
('Grilled Fish', 4, true),
('Shrimp Curry', 4, true),
('Dal Makhani', 5, true),
('Tandoori Roti', 5, true),
('Pav Bhaji', 6, true),
('Chaat Sampler', 6, true);

INSERT INTO menu_item (name, description, menu_id, type, price, rating, is_available) VALUES
('Paneer Butter Masala', 'Creamy and rich paneer curry.', 1, 'VEG_MAIN_COURSE', 250, 4.7, true),
('Garlic Naan', 'Soft Indian bread with garlic and butter.', 1, 'VEG_SNACKS', 50, 4.5, true),
('Mango Lassi', 'Refreshing mango yogurt drink.', 1, 'JUICE', 80, 4.3, true),
('Tandoori Chicken', 'Char-grilled chicken with spices.', 2, 'NON_VEG_STARTER', 300, 4.8, true),
('Chicken Tikka', 'Tender chicken marinated in yogurt and spices.', 2, 'NON_VEG_MAIN_COURSE', 280, 4.6, true),
('Butter Naan', 'Indian bread with butter topping.', 2, 'VEG_SNACKS', 60, 4.4, true),
('Dal Tadka', 'Lentils cooked with Indian spices.', 3, 'VEG_MAIN_COURSE', 200, 4.4, true),
('Jeera Rice', 'Fragrant basmati rice flavored with cumin.', 3, 'VEG_SNACKS', 100, 4.3, true),
('Gulab Jamun', 'Soft deep-fried dumplings in sugar syrup.', 3, 'VEG_DESSERT', 120, 4.6, true),
('Grilled Prawns', 'Prawns marinated and grilled to perfection.', 4, 'NON_VEG_STARTER', 350, 4.7, true),
('Fish Curry', 'Spicy fish curry with coastal flavors.', 4, 'NON_VEG_MAIN_COURSE', 320, 4.6, true),
('Lemon Soda', 'Refreshing lemon-flavored soda.', 4, 'SOFT_DRINK', 70, 4.2, true),
('Paneer Tikka', 'Grilled paneer cubes with a smoky flavor.', 5, 'VEG_STARTER', 220, 4.7, true),
('Veg Biryani', 'Aromatic biryani with mixed vegetables.', 5, 'VEG_MAIN_COURSE', 260, 4.5, true),
('Lassi', 'A thick and creamy yogurt-based drink.', 5, 'JUICE', 90, 4.4, true),
('Dahi Puri', 'Crispy puris filled with yogurt and chutneys.', 6, 'VEG_SNACKS', 120, 4.4, true),
('Chaat Platter', 'A variety of Indian chaats.', 6, 'VEG_SNACKS', 150, 4.6, true),
('Masala Chai', 'Indian spiced tea.', 6, 'SOFT_DRINK', 40, 4.5, true),
('Salmon Steak', 'Grilled salmon with lemon butter sauce.', 7, 'NON_VEG_MAIN_COURSE', 400, 4.8, true),
('Prawn Cocktail', 'Fresh prawns served with tangy cocktail sauce.', 7, 'NON_VEG_STARTER', 320, 4.7, true),
('Fruit Punch', 'Refreshing mixed fruit drink.', 7, 'JUICE', 90, 4.4, true),
('Crab Curry', 'Rich and spicy crab curry.', 8, 'NON_VEG_MAIN_COURSE', 420, 4.6, true),
('Grilled Lobster', 'Lobster grilled to perfection.', 8, 'NON_VEG_STARTER', 500, 4.9, true),
('Coconut Water', 'Fresh coconut water.', 8, 'SOFT_DRINK', 60, 4.3, true),
('BBQ Chicken', 'Tender barbecued chicken.', 9, 'NON_VEG_MAIN_COURSE', 380, 4.7, true),
('Spicy Wings', 'Crispy and spicy chicken wings.', 9, 'NON_VEG_STARTER', 250, 4.6, true),
('Lemon Iced Tea', 'Chilled tea with a hint of lemon.', 9, 'SOFT_DRINK', 70, 4.4, true),
('Veg Biryani', 'Aromatic rice dish with vegetables and spices.', 10, 'VEG_MAIN_COURSE', 240, 4.6, true),
('Raita', 'Yogurt-based side dish with cucumbers and spices.', 10, 'VEG_SNACKS', 80, 4.3, true),
('Masala Chai', 'Indian spiced tea with milk.', 10, 'SOFT_DRINK', 50, 4.5, true),
('Pani Puri', 'Crispy puris filled with spicy water.', 11, 'VEG_SNACKS', 120, 4.7, true),
('Sev Puri', 'Crispy puris topped with potatoes, sev, and chutneys.', 11, 'VEG_SNACKS', 110, 4.6, true),
('Jalebi', 'Sweet and crispy deep-fried dessert.', 11, 'VEG_DESSERT', 150, 4.8, true),
('Aloo Tikki', 'Spiced potato patties served with chutneys.', 12, 'VEG_SNACKS', 130, 4.6, true),
('Dahi Puri', 'Puffed puris filled with yogurt and spices.', 12, 'VEG_SNACKS', 125, 4.7, true),
('Gulab Jamun', 'Soft deep-fried dumplings in sugar syrup.', 12, 'VEG_DESSERT', 140, 4.9, true);

INSERT INTO customer (user_id, address_id, rating) VALUES
(1, 4 ,4.3);

INSERT INTO cart (total_amount, customer_id) VALUES
(0,1);