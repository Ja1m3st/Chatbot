package org.jaime.sanchez.com.chatbot.service;

import org.jaime.sanchez.com.chatbot.model.Question;
import org.jaime.sanchez.com.chatbot.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(String id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    public Optional<Question> findAnswer(String userQuestion) {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .filter(q -> userQuestion.toLowerCase().contains(q.getQuestion().toLowerCase()))
                .findFirst();
    }
}
