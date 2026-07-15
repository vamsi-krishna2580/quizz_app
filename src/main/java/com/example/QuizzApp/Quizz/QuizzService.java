package com.example.QuizzApp.Quizz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizzService {

    private final QuizzRepo quizzRepo;

    public QuizzService(QuizzRepo quizzRepo){
        this.quizzRepo = quizzRepo;
    }

}
