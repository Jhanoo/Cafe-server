INSERT INTO Users (username, password, email, birthday, points)
VALUES
('john_doe', 'password123', 'john@example.com', '1990-05-20', 1000),
('jane_smith', 'securepass', 'jane@example.com', '1995-08-15', 500),
('alice_wonder', 'alice1234', 'alice@example.com', '1988-03-10', 200);

INSERT INTO Menus (name, price, category, image_url, description, average_rating, review_count)
VALUES
('Americano', 4500, 'Coffee', 'images/americano.jpg', 'A classic espresso diluted with water.', 4.5, 1),
('Latte', 5500, 'Coffee', 'images/latte.jpg', 'Espresso mixed with steamed milk.', 4.8, 1),
('Green Tea Latte', 6000, 'Tea', 'images/greentea_latte.jpg', 'Matcha powder mixed with milk.', 4.3, 1),
('Cheesecake', 7000, 'Dessert', 'images/cheesecake.jpg', 'Rich and creamy cheesecake.', 4.9, 1);

INSERT INTO UserStamps (user_id, stamp_count, updated_at)
VALUES
(1, 3, NOW()), -- john_doe has 3 stamps
(2, 5, NOW()), -- jane_smith has 5 stamps
(3, 2, NOW()); -- alice_wonder has 2 stamps

INSERT INTO UserPointTransactions (user_id, type, amount, description, created_at)
VALUES
(1, 'Earned', 500, 'First order bonus', NOW()),
(1, 'Used', 300, 'Order discount', NOW()),
(2, 'Earned', 2000, '5 stamps reward', NOW()),
(3, 'Earned', 100, 'First order bonus', NOW());

INSERT INTO MenuReviews (menu_id, user_id, rating, comment, created_at)
VALUES
(1, 1, 5, 'Best Americano I\'ve ever had!', NOW()),
(2, 2, 4, 'Latte was smooth and creamy.', NOW()),
(3, 3, 3, 'Green Tea Latte was okay, but too sweet.', NOW()),
(4, 1, 5, 'Cheesecake is heavenly!', NOW());

INSERT INTO MenuNutrition (menu_id, calories, protein, fat, carbohydrates, sodium)
VALUES
(1, 10.0, 0.1, 0.0, 2.0, 5.0), -- Americano
(2, 120.0, 6.0, 5.0, 12.0, 10.0), -- Latte
(3, 150.0, 4.0, 4.5, 18.0, 15.0), -- Green Tea Latte
(4, 300.0, 5.0, 20.0, 25.0, 100.0); -- Cheesecake

INSERT INTO Allergens (name)
VALUES
('Milk'),
('Soy'),
('Nuts'),
('Gluten');

INSERT INTO MenuAllergenMapping (menu_id, allergen_id)
VALUES
(2, 1), -- Latte contains Milk
(3, 1), -- Green Tea Latte contains Milk
(4, 1), -- Cheesecake contains Milk
(4, 4); -- Cheesecake contains Gluten

