package com.likelion.springprac.service;

import com.likelion.springprac.domain.User;
import com.likelion.springprac.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // ビジネスロジックを担当するサービスクラス
public class UserService {

    private final UserRepository userRepository;

    // コンストラクタでリポジトリを注入
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create - ユーザー登録
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Read - 全ユーザー取得
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read - IDでユーザー取得
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update - ユーザー情報更新
    public Optional<User> updateUser(Long id, User updateUser) {
        return Optional.of(userRepository.update(id, updateUser));
    }

    // Delete - ユーザー削除
    public boolean deleteUser(Long id) {
        return userRepository.delete(id);
    }
}
