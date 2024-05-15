// PostController.java
package alan.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import alan.backend.model.Post;
import alan.backend.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/")
    public ResponseEntity<?> addPost(@RequestBody Post post) {
        postService.addPost(post);
        return ResponseEntity.ok("Post added successfully.");
    }

    // Other endpoints for listing posts, editing posts, deleting posts, etc.
}
