package ra.model.formater;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ra.model.entity.Category;
import ra.model.service.Category.ICategoryService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;


@Component
public class CategoryFormatter implements Formatter<Category> {
    private ICategoryService categoryService;

    @Autowired
    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> categoryOptional = categoryService.findById(Long.parseLong(text));
        return categoryOptional.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
