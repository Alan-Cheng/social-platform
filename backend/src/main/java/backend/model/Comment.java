package backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String content;

    private String createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", insertable = false, updatable = false)
    private Post post;
    
    @Column(name = "post_id")
    private Long postId;
    
    
    // Getters and setters

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUserId(Long userId) {
    	this.userId = userId;
    }
    
    public Long getUserId() {
    	return userId;
    }
    
    public String getUserName() {
    	return this.user.getUserName();
    }
    
    public void setPostId(Long postId) {
    	this.postId = postId;
    }
    
    public Long getPostId() {
    	return postId;
    }
}