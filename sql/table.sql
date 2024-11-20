drop database if exists ssaf_ssaf;
select @@global.transaction_isolation, @@transaction_isolation;
set @@transaction_isolation="read-committed";

create database ssaf_ssaf;
use ssaf_ssaf;

-- Users 테이블 생성
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    birthday DATE,
    points INT DEFAULT 0
);

-- Menus 테이블 생성
CREATE TABLE Menus (
    menu_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category VARCHAR(50),
    image_url TEXT,
    description TEXT,
    average_rating DECIMAL(3, 2) DEFAULT 0.0,
    review_count INT DEFAULT 0
);

-- UserStamps 테이블 생성
CREATE TABLE UserStamps (
    stamp_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    stamp_count INT DEFAULT 0,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- UserPointTransactions 테이블 생성
CREATE TABLE UserPointTransactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    type ENUM('Earned', 'Used') NOT NULL,
    amount INT NOT NULL,
    description VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- MenuReviews 테이블 생성
CREATE TABLE MenuReviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    menu_id INT,
    user_id INT,
    rating TINYINT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (menu_id) REFERENCES Menus(menu_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- MenuNutrition 테이블 생성
CREATE TABLE MenuNutrition (
    nutrition_id INT AUTO_INCREMENT PRIMARY KEY,
    menu_id INT,
    calories DECIMAL(5, 1),
    protein DECIMAL(5, 1),
    fat DECIMAL(5, 1),
    carbohydrates DECIMAL(5, 1),
    sodium DECIMAL(5, 1),
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
    menu_id INT,
    allergen_id INT,
    FOREIGN KEY (menu_id) REFERENCES Menus(menu_id),
    FOREIGN KEY (allergen_id) REFERENCES Allergens(allergen_id)
);

commit;