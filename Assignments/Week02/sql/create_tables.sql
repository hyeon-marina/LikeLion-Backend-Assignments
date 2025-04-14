-- 새 데이터베이스 생성 및 선택
CREATE DATABASE library_db;
USE library_db;

-- 사용자 테이블
CREATE TABLE users ( -- user는 예약어이므로 테이블명은 users로 변경
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL, -- 이름은 필수 입력 항목이므로 NOT NULL 지정
    email VARCHAR(100) NOT NULL UNIQUE -- 이메일은 중복 되면 안 되므로 UNIQUE 지정
);

-- 책 테이블
CREATE TABLE books ( -- 테이블명은 일반적으로 복수형으로 작성
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL, -- 제목은 반드시 있어야 하므로 NOT NULL
    author VARCHAR(100),
    borrower_id INT,
    FOREIGN KEY (borrower_id) REFERENCES users(id) ON DELETE SET NULL -- 유저 삭제 시 대출자 정보만 NULL 처리

);