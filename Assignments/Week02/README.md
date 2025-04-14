# 🦁 LikeLionバックエンド課題【Week 2】

## 📌 概要

本プロジェクトは、「멋쟁이사자처럼（LikeLion）」のバックエンドトラック第2週目の課題として作成されました。  
Spring Bootを用いてユーザー情報の CRUD（作成・取得・更新・削除）機能を実装しています。

本課題では、REST APIの基本的な構造理解と、Controller / Service / Repository / Domainの責務分離を学習しました。

---

## ⚙️ 使用技術

- Java 17
- Spring Boot 3.4.x
- Gradle
- Spring Web
- Lombok
- JPA（Entityは未使用、Listベースの仮想DB実装）

---

## 📁 ディレクトリ構成

```
Week02/
├── src/
│   └── main/
│       ├── java/com/likelion/springprac/
│       │   ├── SpringPracApplication.java
│       │   ├── controller/
│       │   │   └── UserController.java
│       │   ├── domain/
│       │   │   └── User.java
│       │   ├── repository/
│       │   │   └── UserRepository.java
│       │   └── service/
│       │       └── UserService.java
│       └── resources/
│           └── application.properties
├── sql/
│   └── create_tables.sql
└── README.md
```

---

## 🚀 実装機能

| メソッド | エンドポイント       | 説明                 |
|----------|----------------------|----------------------|
| POST     | `/users`             | ユーザー新規登録     |
| GET      | `/users`             | 全ユーザー一覧取得   |
| GET      | `/users/{id}`        | 特定IDのユーザー取得 |
| PUT      | `/users/{id}`        | ユーザー情報更新     |
| DELETE   | `/users/{id}`        | ユーザー削除         |

---

## 🧠 学んだこと

- Springにおけるレイヤードアーキテクチャの基礎
  - Controller: リクエスト/レスポンス担当
  - Service: ビジネスロジック処理
  - Repository: データ管理
- Optionalでのnull安全な処理
- JavaにおけるLombokアノテーション活用法
- Listベースでの仮想データベース設計
- SQLスキーマ設計（create_tables.sql参照）

---

## 📌 注意点

- このプロジェクトはJPAの永続化を行わず、リストを使った仮想データベースで構成されています。
- 学習目的のため、実際のプロダクションコードとは異なる部分があります。

---

## 🗂️ SQL構造（参考）

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    borrower_id INT,
    FOREIGN KEY (borrower_id) REFERENCES users(id) ON DELETE SET NULL
);
```

---

## 👩‍💻 作者

| 名前 | GitHub | 備考 |
|------|--------|------|
| kwonhayeon | [@hyeon-marina](https://github.com/hyeon-marina) | 韓国の大学に在学中、日本でAIエンジニアとして新卒就職を目指して準備中です。 |

---

## 📮 連絡先

ご質問やフィードバックは、GitHub Issues または Discussions からお気軽にどうぞ！
