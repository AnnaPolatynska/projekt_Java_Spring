package pl.optymalizacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.optymalizacja.model.Post;

@Repository
	public interface PostRepo extends JpaRepository<Post,Long> {
		
	}
