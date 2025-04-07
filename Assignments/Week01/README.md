# 📘 Week 01 - Java 基礎 & 課題実装

## 📆 活動期間
- 2025年4月 第1週

---

## 🧩 学習した概念

- Java における出力方式（`print`, `println`）
- 繰り返し処理（`for`文）
- 配列のスライス（`copyOfRange`, `for`文）
- 例外処理（`IllegalArgumentException`）
- ユーザー入力の取得（`Scanner`）
- 条件分岐（`switch-case`）

---

## ✅ 課題 1: BOJ2439 - 星を出力する

### 📌 問題リンク
[BOJ 2439 - 별 찍기 - 2](https://www.acmicpc.net/problem/2439)

### ✨ 課題概要
- 入力された整数 N に基づき、右寄せされたアスタリスク（星）を出力する。
- 出力フォーマットを正確に合わせる必要がある点がポイント。

### 💻 主要コード
```java
for (int j = 1; j <= n - i; j++) {
    System.out.print(" ");
}
for (int k = 1; k <= i; k++) {
    System.out.print("*");
}
System.out.println();
```

## ✅ 課題 2: PRG181897 - リストのスライス

### 📌 問題リンク
[プログラマーズ 181897 - 리스트 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/181897)

### ✨ 課題概要
- 指定された条件（n, slicer, c）に応じて配列をスライスする問題。
- 4つの方式に応じて処理を分岐し、例外処理・入力バリデーションも含む。

### 💻 主要コード
```java
switch (n) {
    case 1:
        result = Arrays.copyOfRange(num_list, 0, b + 1);
        break;
    ...
    default:
        throw new IllegalArgumentException("スライス方式nは1〜4の間でなければなりません。");
}
```

## 📌 振り返り
この週では、Java の基本文法に初めて触れながら
単純な出力処理から繰り返し、配列操作までの基礎力を鍛えるスタートラインとなった。

特に PRG181897 の課題では、例外処理と条件分岐を自分で設計しながら、
「実際のサービスではこういう処理フローがあるんだ」と実感することができた。

---

## 🔗 関連コードファイル
BOJ2439.java: 星を右寄せで出力する問題（出力制御）

PRG181897.java: 条件に応じたリストスライスと例外処理の実装
