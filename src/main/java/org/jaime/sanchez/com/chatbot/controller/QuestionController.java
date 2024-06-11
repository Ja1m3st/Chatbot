package org.jaime.sanchez.com.chatbot.controller;

import org.jaime.sanchez.com.chatbot.model.Question;
import org.jaime.sanchez.com.chatbot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("/questions")
    public Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionService.deleteQuestion(id);
    }

    @PostMapping("/chat")
    public String getAnswer(@RequestBody String userQuestion) {
        Optional<Question> matchedQuestion = questionService.findAnswer(userQuestion);
        return matchedQuestion.map(Question::getAnswer).orElse("No tengo una respuesta para esa pregunta.");
    }
}
