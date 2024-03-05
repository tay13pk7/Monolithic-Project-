package com.prasad.quizapp.service;


import com.prasad.quizapp.dao.QuestionDao;
import com.prasad.quizapp.dao.QuizDao;
import com.prasad.quizapp.model.Question;
import com.prasad.quizapp.model.QuestionWrapper;
import com.prasad.quizapp.model.Quiz;
import com.prasad.quizapp.model.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title)
    {

        List<Question> questions = questionDao.findRandomQuestionByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Hello it is Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id)
    {
          Optional<Quiz> quiz = quizDao.findById(id); // Even if we put incorrect for a quiz , Optional handles it , read it for more
          List<Question> questionsFromDB  = quiz.get().getQuestions();
          List<QuestionWrapper> questionForUser = new ArrayList<>();

          for(Question q :questionsFromDB )
          {
              QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
              questionForUser.add(qw);
          }

          return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }


    public ResponseEntity<Integer> calculateResult(Integer id, @NotNull List<Response> responses)
    {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int c = 0;
        int i = 0;
        for(Response response : responses)
        {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
            {
                c++;
            }
            i++;
        }

        return new ResponseEntity<>(c,HttpStatus.OK);
    }


}
