package com.example.QuizzApp.Questions.Services;

import com.example.QuizzApp.Questions.Repositories.QuestionRepo;
import com.example.QuizzApp.Questions.Models.Question;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepo questionRepo;
    public QuestionService(QuestionRepo questionRepo){
        this.questionRepo = questionRepo;

    }

    public void createQuestion(Question question) {
        questionRepo.save(question);
    }
    public Question getQuestion(int Id){
        return questionRepo.findById(Id).orElseThrow(()-> new RuntimeException("Not found"));
    }
    public void deleteQuestion(int Id){
        Optional<Question> question = questionRepo.findById(Id);
        if(question.isPresent()){
            questionRepo.deleteById(Id);
        }
    }
    public Question updateQuestion(int Id, Question updatedQuestion){
        Question question = questionRepo.findById(Id).orElseThrow();
        updatedQuestion.setId(question.getId());
        questionRepo.save(updatedQuestion);
        return updatedQuestion;
    }

}
