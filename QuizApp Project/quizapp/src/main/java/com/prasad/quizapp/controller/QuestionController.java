package com.prasad.quizapp.controller;


import com.prasad.quizapp.model.Question;
import com.prasad.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("question")
public class QuestionController {


    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getallQuestions()
    {
        return  questionService.getallQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
            return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }


}


// http://localhost:8080/question/allQuestions
// http://localhost:8080/question/category/Football     by id
// http://localhost:8080/question/add
