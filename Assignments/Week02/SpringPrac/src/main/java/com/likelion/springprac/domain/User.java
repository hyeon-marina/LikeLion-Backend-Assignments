package com.likelion.springprac.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ユーザーエンティティクラス
@Data // getter, setter, toStringなど自動生成
@AllArgsConstructor // 全フィールドを引数に持つコンストラクタ
@NoArgsConstructor // デフォルトコンストラクタ
public class User {
    private Long id; // ユーザーID
    private String name; // 名前
    private String email; // メールアドレス
}
