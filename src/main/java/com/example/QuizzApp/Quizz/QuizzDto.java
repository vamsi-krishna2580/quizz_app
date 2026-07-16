package com.example.QuizzApp.Quizz;

import com.example.QuizzApp.Questions.QuestionDto;
import lombok.Data;

import java.util.List;

@Data
public class QuizzDto {
    private String title;
    private Integer id;
    private List<QuestionDto> questiondtos;
}
