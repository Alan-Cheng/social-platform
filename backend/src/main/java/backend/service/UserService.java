package backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.User;
import backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserPhone(String userphon) {
        return userRepository.findByUserPhone(userphon);
    }
    
    public boolean isValidUser(String userphon, String password) {
        User user = findByUserPhone(userphon);
        return user != null && user.getPassword().equals(password);
    }
    
    public boolean register(User user) {
        if (findByUserPhone(user.getUserPhone()) != null) {
            return false; // 用戶已存在
        }
        userRepository.save(user);
        return true; // 註冊成功
    }
}
