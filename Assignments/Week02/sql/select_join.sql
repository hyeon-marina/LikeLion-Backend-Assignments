USE library_db;

SELECT users.name AS 사용자, books.title AS 대출한_책
FROM users
JOIN books ON users.id = books.borrower_id;
