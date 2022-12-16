package pl.jacekplacek.ideasPro.category.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jacekplacek.ideasPro.category.domain.model.Category;
import pl.jacekplacek.ideasPro.category.service.CategoryService;
import pl.jacekplacek.ideasPro.question.domain.model.Question;
import pl.jacekplacek.ideasPro.question.service.QuestionsService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryViewController {

    private CategoryService categoryService;
    private QuestionsService questionsService;

    public CategoryViewController(CategoryService categoryService, QuestionsService questionsService) {
        this.categoryService = categoryService;
        this.questionsService = questionsService;
    }
    @GetMapping("{id}")
    public String singleView(@PathVariable UUID id, Model model){
        Category category = categoryService.getCategory(id);
        List<Question> questions = questionsService.findAllByCategoryId(id);
        model.addAttribute("category", category);
        model.addAttribute("questions", questions);
        return "category/single";
    }
}
