use ssaf_ssaf;

INSERT INTO Users (name, password, email, birthday, points, stamps)
VALUES 
('Alice', 'password123', 'alice@example.com', '1990-05-15', 100, 2),
('Bob', 'password456', 'bob@example.com', '1985-07-20', 50, 1),
('Charlie', 'password789', 'charlie@example.com', '1992-10-12', 200, 5);


INSERT INTO Menus (name, price, category, image_url, description)
VALUES
('Americano', 3500, 'Coffee', 'americano.png', 'Classic americano with a rich flavor'),
('Cafe Latte', 4000, 'Coffee', 'cafelatte.png', 'Smooth and creamy cafe latte'),
('Cappuccino', 4000, 'Coffee', 'cappuccino.png', 'Foamy and rich cappuccino'),
('Caramel Macchiato', 4500, 'Coffee', 'caramel_macchiato.png', 'Sweet caramel macchiato'),
('Cookie', 2000, 'Dessert', 'cookie.png', 'Delicious cookie to go with your coffee'),
('Grapefruit Ade', 4500, 'Beverage', 'grapefruit_ade.png', 'Refreshing grapefruit ade'),
('Green Tea Latte', 4500, 'Tea', 'greentea_latte.png', 'Creamy green tea latte'),
('Lemonade', 4000, 'Beverage', 'lemonade.png', 'Fresh and tangy lemonade'),
('Mocha Latte', 4500, 'Coffee', 'mocha_latte.png', 'Rich mocha with a hint of chocolate'),
('White Mocha Latte', 4700, 'Coffee', 'white_mocha_latte.png', 'Creamy white mocha latte with a sweet finish');



INSERT INTO Orders (user_id, total_price, order_status, used_point)
VALUES 
(1, 7000, 'Y', 100),
(2, 3000, 'N', 0),
(3, 4000, 'C', 50);


INSERT INTO OrderDetails (order_id, menu_id, quantity)
VALUES 
(1, 1, 2),
(1, 2, 1),
(2, 1, 1),
(3, 2, 1);


-- INSERT INTO ShoppingCart (user_id, menu_id, quantity)
-- VALUES 
-- (1, 3, 2),
-- (2, 2, 1),
-- (3, 1, 3);


INSERT INTO MenuOptions (category, name, price, is_required) VALUES
('Size', 'R', 0, TRUE),
('Size', 'L', 500, TRUE),
('Hot/Ice', 'Hot', 0, TRUE),
('Hot/Ice', 'Ice', 0, TRUE),
('Option', '시럽추가', 500, FALSE),
('Option', '휘핑추가', 300, FALSE),
('Option', '샷 추가', 500, FALSE);

INSERT INTO MenuOptionMapping (menu_id, option_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6),
(3, 7),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(4, 5),
(4, 6),
(4, 7),
(6, 1),
(6, 2),
(6, 3),
(6, 4),
(6, 5),
(6, 6),
(6, 7),
(7, 1),
(7, 2),
(7, 3),
(7, 4),
(7, 5),
(7, 6),
(7, 7),
(8, 1),
(8, 2),
(8, 3),
(8, 4),
(8, 5),
(8, 6),
(8, 7),
(9, 1),
(9, 2),
(9, 3),
(9, 4),
(9, 5),
(9, 6),
(9, 7),
(10, 1),
(10, 2),
(10, 3),
(10, 4),
(10, 5),
(10, 6),
(10, 7);

INSERT INTO OrderOptions (order_detail_id, option_id)
VALUES 
(1, 1),
(1, 2),
(2, 3),
(3, 4);


INSERT INTO MenuReviews (menu_id, user_id, rating, comment)
VALUES 
(1, 1, 5, 'Best espresso I ever had!'),
(2, 2, 4, 'Nice latte but could be hotter.'),
(3, 3, 5, 'Refreshing and perfect for summer.');


INSERT INTO MenuNutrition (menu_id, calories, protein, fat, carbohydrates, sodium)
VALUES 
(1, 10.0, 0.5, 0.2, 2.0, 1.0),
(2, 120.0, 6.0, 5.0, 15.0, 3.0),
(3, 80.0, 0.0, 0.0, 20.0, 0.0);


INSERT INTO Allergens (name) VALUES 
('Milk'),
('Soy'),
('Gluten'),
('Nuts'),
('Eggs');


-- Americano: No allergens
-- Cafe Latte: Milk
INSERT INTO MenuAllergenMapping (menu_id, allergen_id) VALUES 
((SELECT menu_id FROM Menus WHERE name = 'Cafe Latte'), (SELECT allergen_id FROM Allergens WHERE name = 'Milk'));

-- Cappuccino: Milk
INSERT INTO MenuAllergenMapping (menu_id, allergen_id) VALUES 
((SELECT menu_id FROM Menus WHERE name = 'Cappuccino'), (SELECT allergen_id FROM Allergens WHERE name = 'Milk'));

-- Caramel Macchiato: Milk, Soy
INSERT INTO MenuAllergenMapping (menu_id, allergen_id) VALUES 
((SELECT menu_id FROM Menus WHERE name = 'Caramel Macchiato'), (SELECT allergen_id FROM Allergens WHERE name = 'Milk')),
((SELECT menu_id FROM Menus WHERE name = 'Caramel Macchiato'), (SELECT allergen_id FROM Allergens WHERE name = 'Soy'));

-- Cookie: Gluten, Milk, Eggs
INSERT INTO MenuAllergenMapping (menu_id, allergen_id) VALUES 
((SELECT menu_id FROM Menus WHERE name = 'Cookie'), (SELECT allergen_id FROM Allergens WHERE name = 'Gluten')),
((SELECT menu_id FROM Menus WHERE name = 'Cookie'), (SELECT allergen_id FROM Allergens WHERE name = 'Milk')),
((SELECT menu_id FROM Menus WHERE name = 'Cookie'), (SELECT allergen_id FROM Allergens WHERE name = 'Eggs'));

SELECT allergen_id FROM Allergens WHERE name = 'Eggs';

-- Grapefruit Ade: No allergens
-- Green Tea Latte: Milk
INSERT INTO MenuAllergenMapping (menu_id, allergen_id) VALUES 
((SELECT menu_id FROM Menus WHERE name = 'Green Tea Latte'), (SELECT allergen_id FROM Allergens WHERE name = 'Milk'));

-- Lemonade: No allergens
-- Mocha Latte: Milk, Soy
INSERT INTO MenuAllergenMapping (menu_id, allergen_id) VALUES 
((SELECT menu_id FROM Menus WHERE name = 'Mocha Latte'), (SELECT allergen_id FROM Allergens WHERE name = 'Milk')),
((SELECT menu_id FROM Menus WHERE name = 'Mocha Latte'), (SELECT allergen_id FROM Allergens WHERE name = 'Soy'));

-- White Mocha Latte: Milk, Soy, Nuts
INSERT INTO MenuAllergenMapping (menu_id, allergen_id) VALUES 
((SELECT menu_id FROM Menus WHERE name = 'White Mocha Latte'), (SELECT allergen_id FROM Allergens WHERE name = 'Milk')),
((SELECT menu_id FROM Menus WHERE name = 'White Mocha Latte'), (SELECT allergen_id FROM Allergens WHERE name = 'Soy')),
((SELECT menu_id FROM Menus WHERE name = 'White Mocha Latte'), (SELECT allergen_id FROM Allergens WHERE name = 'Nuts'));


