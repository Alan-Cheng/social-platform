package backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Column(name = "user_name", unique = true, nullable = true)
    private String userName;
    
    
    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column
    private String coverImage;

    @Column
    private String biography;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
    	return userPhone;
    }
    
    public void setUserPhone(String userPhone) {
    	this.userPhone = userPhone;
    }
    
    public String getUserName() {
    	return userName != null ? userName : "";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
