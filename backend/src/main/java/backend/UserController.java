package backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            // 加密使用者輸入的密碼
            String encryptedPassword = PasswordUtil.encodePassword(user.getPassword());
            user.setPassword(encryptedPassword);

            boolean isRegistered = userService.register(user);
            if (isRegistered) {
                return ResponseEntity.ok("註冊成功");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("註冊失敗");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("密碼加密失敗");
        }
    }
}
