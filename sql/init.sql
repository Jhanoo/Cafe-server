drop database if exists ssaf_ssaf;
select @@global.transaction_isolation, @@transaction_isolation;
set @@transaction_isolation="read-committed";

create database ssaf_ssaf;
use ssaf_ssaf;

-- Users 테이블 생성
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    birthday DATE,
    points INT DEFAULT 0,
    stamps INT DEFAULT 0
);

-- Menus 테이블 생성
CREATE TABLE Menus (
    menu_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    category VARCHAR(50),
    image_url TEXT,
    description TEXT,
    average_rating DECIMAL(3, 2) DEFAULT 0.0,
    review_count INT DEFAULT 0
);

CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total_price INT NOT NULL,
    order_status ENUM('Pending', 'Completed', 'Canceled') DEFAULT 'Pending',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE OrderDetails (
    order_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    menu_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (menu_id) REFERENCES Menus(menu_id)
);


CREATE TABLE ShoppingCart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    menu_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (menu_id) REFERENCES Menus(menu_id)
);

CREATE TABLE MenuOptions (
    option_id INT AUTO_INCREMENT PRIMARY KEY,
    menu_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    price INT DEFAULT 0,
    is_required BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (menu_id) REFERENCES Menus(menu_id)
);

CREATE TABLE OrderOptions (
    order_option_id INT AUTO_INCREMENT PRIMARY KEY,
    order_detail_id INT NOT NULL,
    option_id INT NOT NULL,
    FOREIGN KEY (order_detail_id) REFERENCES OrderDetails(order_detail_id),
    FOREIGN KEY (option_id) REFERENCES MenuOptions(option_id)
);


-- UserPointTransactions 테이블 생성
CREATE TABLE UserPointTransactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    type ENUM('Earned', 'Used') NOT NULL,
    amount INT NOT NULL,
    description VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- MenuReviews 테이블 생성
CREATE TABLE MenuReviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    menu_id INT NOT NULL,
    user_id INT NOT NULL,
    rating TINYINT NOT NULL,
    comment TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (menu_id) REFERENCES Menus(menu_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);


-- MenuNutrition 테이블 생성
CREATE TABLE MenuNutrition (
    nutrition_id INT AUTO_INCREMENT PRIMARY KEY,
    menu_id INT NOT NULL UNIQUE,
    calories DECIMAL(6, 2),
    protein DECIMAL(5, 1),
    fat DECIMAL(5, 1),
    carbohydrates DECIMAL(5, 1),
    sodium DECIMAL(6, 2),
    FOREIGN KEY (menu_id) REFERENCES Menus(menu_id)
);


-- Allergens 테이블 생성
CREATE TABLE Allergens (
    allergen_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

-- MenuAllergenMapping 테이블 생성
CREATE TABLE MenuAllergenMapping (
    mapping_id INT AUTO_INCREMENT PRIMARY KEY,
    menu_id INT NOT NULL,
    allergen_id INT NOT NULL,
    FOREIGN KEY (menu_id) REFERENCES Menus(menu_id),
    FOREIGN KEY (allergen_id) REFERENCES Allergens(allergen_id),
    UNIQUE(menu_id, allergen_id)
);


CREATE TABLE UserAllergens (
    user_allergen_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    allergen_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (allergen_id) REFERENCES Allergens(allergen_id),
    UNIQUE(user_id, allergen_id)
);

CREATE INDEX idx_user_id ON Users(user_id);
CREATE INDEX idx_menu_id ON Menus(menu_id);
CREATE INDEX idx_order_id ON Orders(order_id);
CREATE INDEX idx_order_detail_id ON OrderDetails(order_detail_id);
CREATE INDEX idx_option_id ON MenuOptions(option_id);
CREATE INDEX idx_mapping_menu_id ON MenuAllergenMapping(menu_id);
CREATE INDEX idx_mapping_allergen_id ON MenuAllergenMapping(allergen_id);
CREATE INDEX idx_user_allergen_user_id ON UserAllergens(user_id);
CREATE INDEX idx_user_allergen_allergen_id ON UserAllergens(allergen_id);


commit;





