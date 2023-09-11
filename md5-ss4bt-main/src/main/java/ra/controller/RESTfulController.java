package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Blog;
import ra.model.entity.Category;
import ra.model.service.Category.ICategoryService;
import ra.model.service.blog.IBlogService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
public class RESTfulController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("getCategory")
    public ResponseEntity<Iterable<Category>> getCategory(){
        List<Category> categories = (List<Category>) categoryService.findAll();
        if(categories.isEmpty()){
            return new   ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( categories,HttpStatus.OK);
    }

    @GetMapping("getBlog")
    public ResponseEntity<Iterable<Blog>> getAllBlog(){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if(blogs.isEmpty()){
            return new   ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( blogs,HttpStatus.OK);
    }

    @GetMapping("getAllBlog/{id}")
    public ResponseEntity<Iterable<Blog>> getBlogByCatalogId(@PathVariable String id){
        List<Blog> blogs = (List<Blog>) blogService.findAllByCategoryId(id);
        if(blogs.isEmpty()){
            return new   ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( blogs,HttpStatus.OK);
    }

    @GetMapping("getBlog/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable String id){
        Blog blog =  blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

}
