package com.prasad.quizapp.dao;

import com.prasad.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
