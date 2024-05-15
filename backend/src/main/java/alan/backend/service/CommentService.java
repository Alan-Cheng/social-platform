// CommentService.java
package alan.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alan.backend.model.Comment;
import alan.backend.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    // Other methods for listing comments, editing comments, deleting comments, etc.
}
