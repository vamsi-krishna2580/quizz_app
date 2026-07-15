package com.example.QuizzApp.Quizz;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizz")
public class QuizzController {

    private final QuizzService quizzService;
    public QuizzController(QuizzService quizzService){
        this.quizzService = quizzService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuizz (@PathVariable int id){
        quizzService.getAll
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }
}
