-- Admin User
INSERT INTO users (email, first_name, last_name, password, role)
VALUES ('s32876_admin@test.com', 'Nikita', 'Admin', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HCGzGzodR1G8b1F4J1Z6y', 1);

-- Standard User
INSERT INTO users (email, first_name, last_name, password, role)
VALUES ('nikita_user@test.com', 'Nikita', 'User', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HCGzGzodR1G8b1F4J1Z6y', 0);


-- ---------------------------------------------------------
-- Equipment Catalog
-- ---------------------------------------------------------

INSERT INTO equipment (name, category, description, price, stock_quantity, version)
VALUES ('MacBook Air M2', 'LAPTOP', 'Apple laptop with M2 chip. Ideal for heavy IDEs and full-stack development.', 45.00, 12, 0);

INSERT INTO equipment (name, category, description, price, stock_quantity, version)
VALUES ('Canon EOS R5', 'CAMERA', 'Professional mirrorless camera perfect for media production.', 85.00, 4, 0);

INSERT INTO equipment (name, category, description, price, stock_quantity, version)
VALUES ('Cisco Catalyst 9300', 'ROUTER', 'Enterprise-grade switch for networking simulations.', 25.00, 8, 0);

INSERT INTO equipment (name, category, description, price, stock_quantity, version)
VALUES ('Dell UltraSharp 27', 'MONITOR', '4K USB-C Hub Monitor for dual-screen setups.', 15.00, 20, 0);