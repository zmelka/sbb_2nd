package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id,  @RequestParam String content) {
        Question question = questionService.getQuestion(id);
        answerService.create(question, content);

        model.addAttribute("question", question);

        return "redirect:/question/detail/%d".formatted(id);
    }
}
