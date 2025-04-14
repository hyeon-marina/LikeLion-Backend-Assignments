package com.likelion.springprac.repository;

import com.likelion.springprac.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository // Springにデータ管理クラスとして認識させる
public class UserRepository {

    // ユーザーデータを保存するリスト（仮想データベース）
    private final List<User> userList = new ArrayList<>();
    private Long idCounter = 1L; // ID自動増加用のカウンター

    // Create - ユーザー保存
    public User save(User user) {
        user.setId(idCounter++); // IDを自動で設定
        userList.add(user); // リストに追加
        return user;
    }

    // Read - 全ユーザー取得
    public List<User> findAll() {
        return List.copyOf(userList); // 不変リストとして返す
    }

    // Read - IDでユーザー取得
    public Optional<User> findById(Long id) {
        return userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    // Update - ユーザー情報更新
    public User update(Long id, User updateUser) {
        User user = findById(id).orElseThrow(() ->
                new IllegalArgumentException("指定されたIDのユーザーが見つかりません。")
        );
        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        return user;
    }

    // Delete - ユーザー削除
    public boolean delete(Long id) {
        return userList.removeIf(user -> user.getId().equals(id));
    }
}
