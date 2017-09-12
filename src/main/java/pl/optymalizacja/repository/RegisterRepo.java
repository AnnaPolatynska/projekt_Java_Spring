package pl.optymalizacja.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.optymalizacja.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Long>{
	List<Register> findAllByLoginAndPassword(String login, String password);
}
