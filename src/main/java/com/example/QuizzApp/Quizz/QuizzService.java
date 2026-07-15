package com.example.QuizzApp.Quizz;

import org.springframework.stereotype.Service;

@Service
public class QuizzService {

    private final QuizzRepo quizzRepo;

    public QuizzService(QuizzRepo quizzRepo){
        this.quizzRepo = quizzRepo;
    }

}
