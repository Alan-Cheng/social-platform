package backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.User;
import backend.service.UserService;
import backend.PasswordUtil;
import backend.model.LoginRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        User user = userService.findByUserPhone(request.getUsername());
        if (user != null) {
            try {
                // 驗證使用者輸入的密碼
                boolean isPasswordValid = PasswordUtil.validatePassword(request.getPassword(), user.getPassword());
                if (isPasswordValid) {
                    return ResponseEntity.ok().body(user);
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("密碼驗證失敗");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}