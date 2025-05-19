# 🦁 LikeLion バックエンド第3週課題 - Session & Feedback API

## ✅ 課題の目的
勉強セッション（Session）とGPTフィードバック（Feedback）ドメインを設計し、1:Nの関係でCRUD APIを実装しました。

## 📦 使用技術
- Spring Boot 3
- Spring Data JPA
- MySQL
- Lombok
- Postman

## 📄 主な機能
- セッションの登録・取得
- フィードバックの登録・取得・セッション別取得
- fetch join による N+1 問題の最適化
- サービス分離およびリファクタリングの適用

## 🔄 API 一覧
| Method | Endpoint | 説明 |
|--------|----------|------|
| POST   | `/sessions` | セッション登録 |
| GET    | `/sessions` | 全セッション取得 |
| GET    | `/sessions/{id}` | 特定セッション取得 |
| POST   | `/feedbacks` | フィードバック登録 |
| GET    | `/feedbacks` | 全フィードバック取得 |
| GET    | `/feedbacks/session/{id}` | セッションごとのフィードバック取得 |

## 🖼️ Postman テストキャプチャ
→ `images/` フォルダをご参照ください

## 🧠 学び・気づき
- JPAのリレーション構築を初めて自分で設計・実装し、概念の理解が深まりました
- 単一責任の原則やfetch joinによるパフォーマンス最適化など、実践的なリファクタリングを経験できました

---

# 🦁 멋쟁이사자처럼 3주차 과제 - Session & Feedback API

## ✅ 과제 목표
공부 세션(Session)과 GPT 피드백(Feedback) 도메인을 설계하고 1:N 관계로 CRUD API를 구현했습니다.

## 📦 기술 스택
- Spring Boot 3
- Spring Data JPA
- MySQL
- Lombok
- Postman

## 📄 주요 기능
- 세션 등록 / 조회
- 피드백 등록 / 조회 / 세션별 조회
- fetch join으로 N+1 문제 해결
- 서비스 분리 및 리팩토링 적용

## 🔄 API 목록
| Method | Endpoint | 설명 |
|--------|----------|------|
| POST   | `/sessions` | 세션 등록 |
| GET    | `/sessions` | 모든 세션 조회 |
| GET    | `/sessions/{id}` | 특정 세션 조회 |
| POST   | `/feedbacks` | 피드백 등록 |
| GET    | `/feedbacks` | 전체 피드백 조회 |
| GET    | `/feedbacks/session/{id}` | 특정 세션의 피드백 조회 |

## 🖼️ Postman 테스트 캡처
→ `images/` 폴더 참고

## 🧠 느낀 점
- JPA의 연관관계를 처음으로 직접 설계하며 실습해보며 개념을 체득할 수 있었음
- 단일 책임 원칙 적용, fetch join 최적화 등을 통해 실무적인 리팩토링 경험