use ssaf_ssaf;

INSERT INTO Users (name, password, email, birthday, points, stamps)
VALUES 
('Alice', 'password123', 'alice@example.com', '1990-05-15', 100, 2),
('Bob', 'password456', 'bob@example.com', '1985-07-20', 50, 1),
('Charlie', 'password789', 'charlie@example.com', '1992-10-12', 200, 5);


INSERT INTO Menus (name, price, category, image_url, description)
VALUES 
('Espresso', 3000, 'Coffee', 'espresso.jpg', 'Strong and bold coffee'),
('Latte', 4000, 'Coffee', 'latte.jpg', 'Smooth and creamy'),
('Green Tea', 3500, 'Tea', 'green_tea.jpg', 'Refreshing green tea');


INSERT INTO Orders (user_id, total_price, order_status, used_point)
VALUES 
(1, 7000, '완료', 100),
(2, 3000, '준비중', 0),
(3, 4000, '취소', 50);


INSERT INTO OrderDetails (order_id, menu_id, quantity)
VALUES 
(1, 1, 2),
(1, 2, 1),
(2, 1, 1),
(3, 2, 1);


INSERT INTO ShoppingCart (user_id, menu_id, quantity)
VALUES 
(1, 3, 2),
(2, 2, 1),
(3, 1, 3);


INSERT INTO MenuOptions (menu_id, name, price, is_required)
VALUES 
(1, 'Extra Shot', 500, TRUE),
(1, 'Soy Milk', 300, FALSE),
(2, 'Whipped Cream', 200, FALSE),
(3, 'Honey', 400, FALSE);


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


INSERT INTO Allergens (name)
VALUES 
('Milk'),
('Soy'),
('Nuts');


INSERT INTO MenuAllergenMapping (menu_id, allergen_id)
VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 2);


INSERT INTO UserAllergens (user_id, allergen_id)
VALUES 
(1, 1),
(2, 2),
(3, 3);

