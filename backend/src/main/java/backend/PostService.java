package backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    
    public Post createPost(Post post, Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            post.setUserId(userId);
            // 这里可以添加其他逻辑，比如设置创建时间等
            return postRepository.save(post);
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
    }
    
}
