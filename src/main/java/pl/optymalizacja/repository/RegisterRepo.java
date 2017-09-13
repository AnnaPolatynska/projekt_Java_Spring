package pl.optymalizacja.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.optymalizacja.model.Regist;

@Repository
public interface RegisterRepo extends JpaRepository<Regist, Long>{
	List<Regist> findAllByLoginAndPassword(String login, String password);
}
