package ra.model.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Blog;
import ra.model.entity.Category;
import ra.model.repository.IBlogRepository;
import ra.model.service.Category.ICategoryService;

import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private ICategoryService categoryService;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }


    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return (Iterable<Blog>) blogRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Blog> findAllByCategoryId(String id) {
        Optional<Category> category = null;
        try{
            Long idCatalog = Long.parseLong(id);
            category = categoryService.findById(idCatalog);
        }catch (Exception e){
            return null;
        }
        return (Iterable<Blog>) blogRepository.findAllByCategory(category.get());
    }

    @Override
    public Blog findById(String id) {
        Optional<Blog> blog = null;
        try{
            Long idFind = Long.parseLong(id);
            blog = blogRepository.findById(idFind);
        }catch (Exception e){
            return null;
        }
        if (blog.isPresent()){
            return blog.get();
        }
        return null;
    }

}
