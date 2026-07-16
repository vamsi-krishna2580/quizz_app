package com.example.QuizzApp.Quizz.Services;

import com.example.QuizzApp.Questions.Models.Question;
import com.example.QuizzApp.Questions.Models.QuestionDto;
import com.example.QuizzApp.Quizz.Models.Quizz;
import com.example.QuizzApp.Quizz.Repositories.QuizzRepo;
import com.example.QuizzApp.Quizz.Models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizzService {

    private final QuizzRepo quizzRepo;

    public QuizzService(QuizzRepo quizzRepo){
        this.quizzRepo = quizzRepo;
    }

    public ResponseEntity<?> getQuizz(Integer id) {
        try{
            Quizz quizz = quizzRepo.findById(id).orElseThrow(()-> new RuntimeException("Quizz not found"));
            List<Question> questions = quizz.getQuestions();
            List<QuestionDto> questionDtos = new ArrayList<>();
            for(Question question : questions){
                questionDtos.add(new QuestionDto(question));
            }
            return new ResponseEntity<>(questionDtos, HttpStatus.OK);

        }catch(RuntimeException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> createQuizz(String title, String category, int numQ) {
        List<Question> questions = quizzRepo.findByCategoryRandom(numQ, category);
        System.out.println(questions);
        Quizz quizz = new Quizz();
        quizz.setTitle(title);
        quizz.setQuestions(questions);
        quizzRepo.save(quizz);
            return new ResponseEntity<String>("Quizz Created with id = "+quizz.getId(), HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> caluclateResult(Integer id, List<Response> responses){
        Quizz quizz = quizzRepo.findById(id).orElseThrow(()-> new RuntimeException("Quizz not found"));
        List<Question> questions = quizz.getQuestions();
        int i = 0, right = 0;
        for(Question question : questions){
            if(question.getRightAnswer().equals(responses.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return ResponseEntity.ok(right);
    }
}

