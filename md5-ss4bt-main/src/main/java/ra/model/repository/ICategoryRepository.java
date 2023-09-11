package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
