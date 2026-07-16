package com.example.QuizzApp.Questions.Repositories;

import com.example.QuizzApp.Questions.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
