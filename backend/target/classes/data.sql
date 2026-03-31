-- Users (password stored as plain text for development)
INSERT INTO users (name, email, password, role) VALUES ('Aarav Sharma', 'aarav@email.com', 'password123', 'ARTIST');
INSERT INTO users (name, email, password, role) VALUES ('Meera Patel', 'meera@email.com', 'password123', 'ARTIST');
INSERT INTO users (name, email, password, role) VALUES ('Ravi Kumar', 'ravi@email.com', 'password123', 'VISITOR');
INSERT INTO users (name, email, password, role) VALUES ('Priya Singh', 'priya@email.com', 'password123', 'CURATOR');
INSERT INTO users (name, email, password, role) VALUES ('Admin User', 'admin@email.com', 'admin123', 'ADMIN');

-- Artworks
INSERT INTO artworks (title, description, price, category, status, image_url, artist) VALUES ('Sunset Over Mountains', 'A beautiful sunset landscape', 5000, 'Painting', 'Published', '', 'Aarav');
INSERT INTO artworks (title, description, price, category, status, image_url, artist) VALUES ('Ocean Breeze', 'Calm ocean waves at dusk', 7200, 'Painting', 'Published', '', 'Meera');
INSERT INTO artworks (title, description, price, category, status, image_url, artist) VALUES ('Golden Fields', 'Golden wheat fields at sunset', 6100, 'Painting', 'Pending', '', 'Ravi');
INSERT INTO artworks (title, description, price, category, status, image_url, artist) VALUES ('Pencil Sketch Portrait', 'Detailed pencil sketch', 2500, 'Drawing', 'Published', '', 'Priya');
INSERT INTO artworks (title, description, price, category, status, image_url, artist) VALUES ('Charcoal Art', 'Expressive charcoal drawing', 3200, 'Drawing', 'Published', '', 'Meera');
INSERT INTO artworks (title, description, price, category, status, image_url, artist) VALUES ('Nature Shot', 'Stunning nature photography', 4800, 'Photography', 'Pending', '', 'Aarav');
INSERT INTO artworks (title, description, price, category, status, image_url, artist) VALUES ('Wildlife Capture', 'Wildlife in natural habitat', 5500, 'Photography', 'Published', '', 'Ravi');
INSERT INTO artworks (title, description, price, category, status, image_url, artist) VALUES ('Modern Bronze', 'Contemporary bronze sculpture', 9800, 'Sculpture', 'Published', '', 'Priya');

-- Exhibitions
INSERT INTO exhibitions (name, description, artworks_count, start_date, end_date, status) VALUES ('Modern Impressions', 'A collection of modern art', 12, '2026-03-01', '2026-03-31', 'Upcoming');
INSERT INTO exhibitions (name, description, artworks_count, start_date, end_date, status) VALUES ('Colors of India', 'Vibrant Indian art showcase', 18, '2026-02-10', '2026-02-28', 'Active');
INSERT INTO exhibitions (name, description, artworks_count, start_date, end_date, status) VALUES ('Abstract Visions', 'Abstract art exhibition', 8, '2026-01-05', '2026-01-25', 'Completed');

-- Purchases
INSERT INTO purchases (artwork, artist, buyer, amount, purchase_date, status) VALUES ('Sunset Over Mountains', 'Aarav', 'Ravi Kumar', 5000, '2026-02-18', 'Delivered');
INSERT INTO purchases (artwork, artist, buyer, amount, purchase_date, status) VALUES ('Pencil Sketch', 'Priya', 'Ravi Kumar', 2500, '2026-02-21', 'Shipped');
INSERT INTO purchases (artwork, artist, buyer, amount, purchase_date, status) VALUES ('Nature Shot', 'Aarav', 'Ravi Kumar', 4800, '2026-02-23', 'Processing');
INSERT INTO purchases (artwork, artist, buyer, amount, purchase_date, status) VALUES ('Ocean Breeze', 'Meera', 'Priya Singh', 7200, '2026-02-18', 'Completed');
INSERT INTO purchases (artwork, artist, buyer, amount, purchase_date, status) VALUES ('Golden Fields', 'Ravi', 'Aarav Sharma', 6100, '2026-02-22', 'Pending');
