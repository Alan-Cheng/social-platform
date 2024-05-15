// PostService.java
package alan.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alan.backend.model.Post;
import alan.backend.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void addPost(Post post) {
        postRepository.save(post);
    }

    // Other methods for listing posts, editing posts, deleting posts, etc.
}
