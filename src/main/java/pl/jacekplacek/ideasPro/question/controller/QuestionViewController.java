package pl.jacekplacek.ideasPro.question.controller;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jacekplacek.ideasPro.common.configuration.IdeasConfiguration;
import pl.jacekplacek.ideasPro.common.controller.IdeasCommonViewController;
import pl.jacekplacek.ideasPro.question.domain.model.Question;
import pl.jacekplacek.ideasPro.question.service.AnswerService;
import pl.jacekplacek.ideasPro.question.service.QuestionService;

import java.util.List;
import java.util.UUID;

import static pl.jacekplacek.ideasPro.common.controller.ControllerUtils.paging;

@Controller
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionViewController extends IdeasCommonViewController {

    private final QuestionService questionsService;
    private final AnswerService answerService;
    private final IdeasConfiguration ideasConfiguration;

    @GetMapping
    public String indexView(
            @NotNull Model model
    ) {

        List<Question> questions = questionsService.getQuestions();

        model.addAttribute("questions", questions);
        addGlobalAttributes(model);

        return "question/index";
    }

    @GetMapping("{id}")
    public String singleView(@NotNull Model model, @PathVariable UUID id) {
        model.addAttribute("question", questionsService.getQuestion(id));
        model.addAttribute("answers", answerService.getAnswers(id));
        addGlobalAttributes(model);

        return "question/single";
    }

    @GetMapping("add")
    public String addView(@NotNull Model model) {
        model.addAttribute("question", new Question());

        return "question/add";
    }

    @PostMapping
    public String add(Question question) {
        questionsService.createQuestion(question);

        return "redirect:/questions";
    }

    @GetMapping("hot")
    public String hotView(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @NotNull Model model
    ) {

        PageRequest pageRequest = PageRequest.of(page - 1, ideasConfiguration.getPagingPageSize());

        Page<Question> questionsPage = questionsService.findHot(pageRequest);

        model.addAttribute("questionsPage", questionsPage);
        paging(model, questionsPage);
        addGlobalAttributes(model);

        return "question/index";
    }

    @GetMapping("unanswered")
    public String unansweredView(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @NotNull Model model
    ) {

        PageRequest pageRequest = PageRequest.of(page - 1, ideasConfiguration.getPagingPageSize());

        Page<Question> questionsPage = questionsService.findUnanswered(pageRequest);

        model.addAttribute("questionsPage", questionsPage);
        paging(model, questionsPage);
        addGlobalAttributes(model);

        return "question/index";
    }
}