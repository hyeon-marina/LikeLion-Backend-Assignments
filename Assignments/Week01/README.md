# 📘 Week 01 - Java 기초 & 문제 풀이

## 📆 활동 기간
- 2025년 4월 1주차

## 🧩 배운 개념
- Java 출력 방식 (`print`, `println`)
- 반복문(`for`) 활용
- 배열 슬라이싱 (`copyOfRange`, `for`문)
- 예외 처리 (`IllegalArgumentException`)
- 사용자 입력 (`Scanner`)
- 조건 분기 (`switch-case`)

---

## ✅ 과제 1: BOJ2439 - 별 찍기 2

- 📌 [문제 링크](https://www.acmicpc.net/problem/2439)

### ✨ 과제 요약
- 입력된 정수 N에 따라 오른쪽 정렬된 별 출력
- 출력 형식 정확히 맞추는 것이 핵심

### 💻 주요 코드
```java
for (int j = 1; j <= n-i; j++) {
    System.out.print(" ");
}
for (int k = 1; k <= i; k++) {
    System.out.print("*");
}
System.out.println();
```

---

## ✅ 과제 2: PRG181897 - 리스트 자르기

- 📌 [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181897)

### ✨ 과제 요약
- 배열을 주어진 조건(n, slicer, c)에 따라 슬라이싱
- 1~4번 방식에 따라 자르며, 예외처리 및 유효성 검사 포함

### 💻 주요 코드
```java
switch (n) {
    case 1:
        result = Arrays.copyOfRange(num_list, 0, b + 1);
        break;
    ...
    default:
        throw new IllegalArgumentException("슬라이싱 방식 n은 1~4 사이여야 합니다.");
}
```

---

## 📌 회고

이 주차는 Java 문법을 처음 접하면서,  
단순 출력부터 반복문, 배열 처리까지 **기본기 훈련의 시작점**이었다.  
특히 PRG181897 과제를 통해 **예외 처리와 분기 처리**를 직접 구성해보며  
“실제 서비스를 만들 때 이런 흐름이 있겠구나”를 체감했다.

---

## 🔗 관련 코드 파일
- `BOJ2439.java`: 별 찍기 문제
- `PRG181897.java`: 리스트 자르기 + 예외 처리 문제
