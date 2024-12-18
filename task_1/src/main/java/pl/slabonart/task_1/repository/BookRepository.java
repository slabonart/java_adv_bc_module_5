package pl.slabonart.task_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slabonart.task_1.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByBookId(Long bookId);

}
