package ra.model.service.blog;


import org.springframework.data.domain.Page;
import ra.model.entity.Blog;
import ra.model.entity.Category;
import ra.model.service.IGenerateService;

public interface IBlogService extends IGenerateService<Blog> {
    Iterable<Blog> findAllByCategory(Category category);
    Iterable<Blog> findAllByCategoryId(String id);
    Blog findById(String id);
}
