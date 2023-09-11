package ra.model.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Blog;
import ra.model.entity.Category;

import java.util.Iterator;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Iterator<Blog> findAllByCategory(Category category);

}
