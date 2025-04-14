USE library_db;

-- 사용자 데이터 삽입
INSERT INTO users (name, email)
VALUES
('김멋사', 'kim@skhu.ac.kr'),
('이멋사', 'lee@skhu.ac.kr'),
('박멋사', 'park@skhu.ac.kr');

-- 책 데이터 삽입
INSERT INTO books (title, author, borrower_id)
VALUES
('컴퓨터구조', '신종홍', 1),
('CentOS리눅스', '이종원', 2),
('사이버사고대응실무', '스티브앤슨', 1);

-- 확인용 쿼리
SELECT * FROM users;
SELECT * FROM books;
