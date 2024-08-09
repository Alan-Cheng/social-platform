package backend.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String content;

    private String createdAt;
    
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    
    
    // Getters and setters

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
    
    public List<Comment> getComments(){ 
        return comments;
    }
    
    public void setComments(List<Comment> comments) {
    	this.comments = comments;
    }
}
