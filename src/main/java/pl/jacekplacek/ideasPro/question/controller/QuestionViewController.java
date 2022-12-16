package pl.jacekplacek.ideasPro.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jacekplacek.ideasPro.category.service.CategoryService;
import pl.jacekplacek.ideasPro.question.domain.model.Question;
import pl.jacekplacek.ideasPro.question.service.AnswerService;
import pl.jacekplacek.ideasPro.question.service.QuestionsService;

import java.util.UUID;

@Controller
@RequestMapping("/questions")
public class QuestionViewController {

    private final QuestionsService questionsService;
    private final AnswerService answerService;
    private final CategoryService categoryService;

    public QuestionViewController(QuestionsService questionsService, AnswerService answerService, CategoryService categoryService) {
        this.questionsService = questionsService;
        this.answerService = answerService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String indexView(Model model) {
        model.addAttribute("questions", questionsService.getQuestions());
        model.addAttribute("categories", categoryService.getCategories());

//        return "template";
        return "question/index";
    }

    @GetMapping("{id}")
    public String singleView(Model model, @PathVariable UUID id) {
        model.addAttribute("question", questionsService.getQuestion(id));
        model.addAttribute("answers", answerService.getAnswers(id));
        model.addAttribute("categories", categoryService.getCategories());

        return "question/single";
    }

    @GetMapping("add")
    public String addView(Model model) {
        model.addAttribute("question", new Question());

        return "question/add";
    }

    @PostMapping
    public String add(Question question) {
        questionsService.createQuestion(question);
        return "redirect:/questions";
    }


}
