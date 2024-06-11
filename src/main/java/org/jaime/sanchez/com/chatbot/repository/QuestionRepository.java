package org.jaime.sanchez.com.chatbot.repository;

import org.jaime.sanchez.com.chatbot.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
