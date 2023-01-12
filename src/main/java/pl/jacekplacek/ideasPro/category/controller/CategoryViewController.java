package pl.jacekplacek.ideasPro.category.controller;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jacekplacek.ideasPro.category.domain.model.Category;
import pl.jacekplacek.ideasPro.category.service.CategoryService;
import pl.jacekplacek.ideasPro.common.controller.IdeasCommonViewController;
import pl.jacekplacek.ideasPro.question.domain.model.Question;
import pl.jacekplacek.ideasPro.question.service.QuestionService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryViewController extends IdeasCommonViewController {

    private final CategoryService categoryService;
    private final QuestionService questionService;

    @GetMapping("{id}")
    public String singleView(@PathVariable UUID id, @NotNull Model model) {

        Category category = categoryService.getCategory(id);
        List<Question> questions = questionService.findAllByCategoryId(id);

        model.addAttribute("category", category);
        model.addAttribute("questions", questions);
        addGlobalAttributes(model);

        return "category/single";

    }
}