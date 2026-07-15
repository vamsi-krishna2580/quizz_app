package com.example.QuizzApp.Questions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createQuizz(@RequestBody Question question){
        questionService.createQuestion(question);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable int id){
        try {
            Question question = questionService.getQuestion(id);
            return new ResponseEntity<>(question, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        try {
            questionService.deleteQuestion(id);
            return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody Question question){
        questionService.updateQuestion(id, question);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

}
