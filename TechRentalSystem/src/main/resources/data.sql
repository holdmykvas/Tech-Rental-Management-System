-- Admin User
INSERT INTO users (email, first_name, last_name, password, role)
VALUES ('admin@test.com', 'Nikita', 'Admin', '$2a$12$U/4pUtL2rBwmRgEho8eOY.dynHf.QjXW/uevTkgGWDomnjDWDg1Vm', 1);

-- Standard User
INSERT INTO users (email, first_name, last_name, password, role)
VALUES ('user@test.com', 'Nikita', 'User', '$2a$12$U/4pUtL2rBwmRgEho8eOY.dynHf.QjXW/uevTkgGWDomnjDWDg1Vm', 0);


-- ---------------------------------------------------------
-- Equipment Catalog
-- ---------------------------------------------------------

INSERT INTO equipment (name, category, description, price, stock_quantity, version)
VALUES ('MacBook Air M2', 'LAPTOP', 'Apple laptop with M2 chip. Ideal for heavy IDEs and full-stack development.', 45.00, 12, 0);

INSERT INTO equipment (name, category, description, price, stock_quantity, version)
VALUES ('Canon EOS R5', 'CAMERA', 'Professional mirrorless camera perfect for media production.', 85.00, 4, 0);

INSERT INTO equipment (name, category, description, price, stock_quantity, version)
VALUES ('Cisco Catalyst 9300', 'ACCESSORY', 'Enterprise-grade switch for networking simulations.', 25.00, 8, 0);