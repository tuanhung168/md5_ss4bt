package ra.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Category;
import ra.model.service.Category.ICategoryService;
import ra.model.service.blog.IBlogService;

import java.util.Optional;


@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("/category")
    private String listCategory(Model model){
        model.addAttribute("categorys", categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/createCategory")
    public ModelAndView createCategory(){
        return new ModelAndView("/category/create", "category", new Category());
    }

    @PostMapping("/createCategory")
    public String doCreateCategory(@ModelAttribute  Category category){
        categoryService.save(category);
        return "redirect:/category";
    }


    @GetMapping("/editCategory/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/editCategory")
    private String doEditCategory(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.remove(id);
        return "redirect:/category";
    }

}
