package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}




