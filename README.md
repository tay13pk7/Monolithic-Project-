# Monolithic-Project-



Monolithic Quiz Application Using Sprint Boot

DB - Postgres
Tables will be created as the application is executed, in application.properties auto-update is on


Postman API calls -  Please read the endpoints in Controller in 

Question Service

// http://localhost:8080/question/allQuestions
// http://localhost:8080/question/category/Football     by id
// http://localhost:8080/question/add


Quiz Service 


// http://localhost:8080/quiz/create?category=Java&numQ=2&title=JQuiz
// http://localhost:8080/quiz/create?category=Football&numQ=5&title=FootballQuiz
// http://localhost:8080/quiz/get/2
// http://localhost:8080/quiz/submit/2



//[
//        {
//        "id":2,
//        "response":"*"
//        },
//        {
//        "id":52,
//        "response":"Cristiano Ronaldo"
//        },
//        {
//        "id":203,
//        "response":"Real Madrid"
//        },
//        {
//        "id":202,
//        "response":"Real Madrid"
//        },
//        {
//        "id":102,
//        "response":"Messi"
//        }
//        ]



