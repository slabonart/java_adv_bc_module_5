package pl.slabonart.task_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slabonart.task_1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
