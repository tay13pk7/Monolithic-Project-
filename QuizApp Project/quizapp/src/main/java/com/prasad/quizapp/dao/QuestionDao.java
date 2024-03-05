package com.prasad.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.prasad.quizapp.model.Question;
import java.util.*;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);


    @Query(value = "Select * from question where category =:category order by RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category,int numQ);


}
