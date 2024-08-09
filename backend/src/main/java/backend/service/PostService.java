package backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Post;
import backend.repository.PostRepository;
import backend.model.User;
import backend.repository.UserRepository;

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
        // 验证 userId 是否有效
        if (userId == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }
        // 查找用户
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            // 设置 post 的 userId
            post.setUserId(userId);
            // 保存 post
            return postRepository.save(post);
        } else {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
    }
    
    public void deletePost(Long postId) {
        // 验证 postId 是否有效
        if (postId == null) {
            throw new IllegalArgumentException("Post ID must not be null");
        }

        // 检查帖子是否存在
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            // 删除帖子
            postRepository.deleteById(postId);
        } else {
            throw new IllegalArgumentException("Post with ID " + postId + " not found");
        }
    }
}
