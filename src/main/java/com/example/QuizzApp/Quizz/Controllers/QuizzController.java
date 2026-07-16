package com.example.QuizzApp.Quizz.Controllers;


import com.example.QuizzApp.Quizz.Services.QuizzService;
import com.example.QuizzApp.Quizz.Models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizz")
public class QuizzController {

    private final QuizzService quizzService;
    public QuizzController(QuizzService quizzService){
        this.quizzService = quizzService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuizz (@PathVariable Integer id){
        return quizzService.getQuizz(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createQuizz (
            @RequestParam String title,
            @RequestParam String category,
            @RequestParam int numQ
            ){
        return quizzService.createQuizz(title, category, numQ);
    }

    @PostMapping("/result/{id}")
    public ResponseEntity<Integer> calculateResult(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizzService.caluclateResult(id, responses);
    }
}
