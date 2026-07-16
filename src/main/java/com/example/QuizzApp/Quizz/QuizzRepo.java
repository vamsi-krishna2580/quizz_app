package com.example.QuizzApp.Quizz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzRepo extends JpaRepository<Quizz, Integer> {
}
