package backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUserPhone(@Param("userPhone") String userPhone);
    Optional<User> findById(Long userId);
    
    
}
