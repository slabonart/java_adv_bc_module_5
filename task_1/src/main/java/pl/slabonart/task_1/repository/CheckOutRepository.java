package pl.slabonart.task_1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slabonart.task_1.model.CheckOut;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {

    boolean existsByBookId(Long bookId);

    @Transactional
    void deleteByBookId(Long bookId);

}
