CREATE TABLE Users (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email_address VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Merchant (
    id UUID PRIMARY KEY,
    merchant_name VARCHAR(255) NOT NULL,
    merchant_location VARCHAR(255),
    open BOOLEAN NOT NULL
);

CREATE TABLE Product (
    id UUID PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    merchant_id UUID REFERENCES Merchant(id) ON DELETE CASCADE
);

CREATE TABLE "Order" (
    id UUID PRIMARY KEY,
    order_time TIMESTAMP NOT NULL,
    destination_address VARCHAR(255) NOT NULL,
    user_id UUID REFERENCES Users(id) ON DELETE CASCADE,
    completed BOOLEAN NOT NULL
);

CREATE TABLE Order_Detail (
    id UUID PRIMARY KEY,
    order_id UUID REFERENCES "Order"(id) ON DELETE CASCADE,
    product_id UUID REFERENCES Product(id) ON DELETE CASCADE,
    quantity INTEGER NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL
);
