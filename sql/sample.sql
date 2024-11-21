-- Users 테이블 샘플 데이터 추가
INSERT INTO Users (name, password, email, birthday, points, stamps)
VALUES 
('user1', 'password1', 'user1@example.com', '1990-01-01', 100, 5),
('user2', 'password2', 'user2@example.com', '1985-05-15', 200, 10),
('user3', 'password3', 'user3@example.com', '2000-09-10', 50, 2);

-- Menus 테이블 샘플 데이터 추가
INSERT INTO Menus (name, price, category, image_url, description, average_rating, review_count)
VALUES 
('Americano', 3000, 'Coffee', 'https://example.com/americano.jpg', 'A simple Americano.', 4.5, 10),
('Latte', 4000, 'Coffee', 'https://example.com/latte.jpg', 'A creamy latte.', 4.7, 15),
('Green Tea', 3500, 'Tea', 'https://example.com/green_tea.jpg', 'A refreshing green tea.', 4.2, 8);

-- Orders 테이블 샘플 데이터 추가
INSERT INTO Orders (user_id, total_price, order_status)
VALUES 
(1, 7000, 'Completed'),
(2, 3000, 'Pending'),
(3, 4000, 'Canceled');

-- OrderDetails 테이블 샘플 데이터 추가
INSERT INTO OrderDetails (order_id, menu_id, quantity)
VALUES 
(1, 1, 2),
(1, 2, 1),
(2, 1, 1);

-- ShoppingCart 테이블 샘플 데이터 추가
INSERT INTO ShoppingCart (user_id, menu_id, quantity)
VALUES 
(1, 2, 1),
(2, 3, 2),
(3, 1, 3);

-- MenuOptions 테이블 샘플 데이터 추가
INSERT INTO MenuOptions (menu_id, name, price, is_required)
VALUES 
(1, 'Extra Shot', 500, FALSE),
(2, 'Soy Milk', 300, TRUE),
(3, 'Honey', 200, FALSE);

-- OrderOptions 테이블 샘플 데이터 추가
INSERT INTO OrderOptions (order_detail_id, option_id)
VALUES 
(1, 1),
(2, 2),
(3, 3);

-- UserPointTransactions 테이블 샘플 데이터 추가
INSERT INTO UserPointTransactions (user_id, type, amount, description)
VALUES 
(1, 'Earned', 50, 'Purchased coffee'),
(2, 'Used', 20, 'Discount applied'),
(3, 'Earned', 30, 'Promo points');

-- MenuReviews 테이블 샘플 데이터 추가
INSERT INTO MenuReviews (menu_id, user_id, rating, comment)
VALUES 
(1, 1, 5, 'Great coffee!'),
(2, 2, 4, 'Very creamy latte.'),
(3, 3, 3, 'Good but not great.');

-- MenuNutrition 테이블 샘플 데이터 추가
INSERT INTO MenuNutrition (menu_id, calories, protein, fat, carbohydrates, sodium)
VALUES 
(1, 10.5, 0.5, 0.1, 2.0, 0.3),
(2, 150.0, 6.0, 4.5, 12.0, 100.0),
(3, 30.0, 0.0, 0.1, 7.0, 20.0);

-- Allergens 테이블 샘플 데이터 추가
INSERT INTO Allergens (name)
VALUES 
('Milk'),
('Nuts'),
('Gluten');

-- MenuAllergenMapping 테이블 샘플 데이터 추가
INSERT INTO MenuAllergenMapping (menu_id, allergen_id)
VALUES 
(2, 1),
(3, 2);

-- UserAllergens 테이블 샘플 데이터 추가
INSERT INTO UserAllergens (user_id, allergen_id)
VALUES 
(1, 1),
(2, 2);
