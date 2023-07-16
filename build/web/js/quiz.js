//References
let timeLeft = document.querySelector(".time-left");
let quizContainer = document.getElementById("container");
let nextBtn = document.getElementById("next-button");
let countOfQuestion = document.querySelector(".number-of-question");
let displayContainer = document.getElementById("display-container");
let scoreContainer = document.querySelector(".score-container");
let restart = document.getElementById("restart");
let userScore = document.getElementById("user-score");
let startScreen = document.querySelector(".start-screen");
let startButton = document.getElementById("start-button");
let params = new URL(document.location).searchParams;
let quizid = parseInt(params.get("quizid"));
let questionCount;
let scoreCount = 0;
let count = 11;
let countdown;

//Questions and Options array


let quizArray = [];
$(document).ready(function () {
    $.ajax({
        url: 'http://localhost:8080/Student/quizdisplay?quizid=' + quizid,
        method: 'GET',
        context: document.body,
        success: function (responseText) {
            if (responseText) {
                quizArray = JSON.parse(responseText);
                console.log(JSON.parse(responseText))
            }
        }
    });
});

//Restart Quiz
restart.addEventListener("click", () => {
    initial();
    displayContainer.classList.remove("hide");
    scoreContainer.classList.add("hide");
});

//Next Button
nextBtn.addEventListener(
    "click",
    (displayNext = () => {
        //increment questionCount
        questionCount += 1;
        //if last question
        if (questionCount == quizArray.length) {
            //hide question container and display score
            displayContainer.classList.add("hide");
            scoreContainer.classList.remove("hide");
            //user score
            userScore.innerHTML =
                "Your score is " + scoreCount + " out of " + questionCount;
        } else {
            //display questionCount
            countOfQuestion.innerHTML =
                questionCount + 1 + " of " + quizArray.length + " Question";
            //display quiz
            quizDisplay(questionCount);
            count = 11;
            clearInterval(countdown);
            timerDisplay();
        }
    })
);

//Timer
const timerDisplay = () => {
    countdown = setInterval(() => {
        count--;
        timeLeft.innerHTML = `${count}s`;
        if (count == 0) {
            clearInterval(countdown);
            displayNext();
        }
    }, 1000);
};

//Display quiz
const quizDisplay = (questionCount) => {
    let quizCards = document.querySelectorAll(".container-mid");
    //Hide other cards
    quizCards.forEach((card) => {
        card.classList.add("hide");
    });
    //display current question card
    if (quizCards[questionCount]) {
        quizCards[questionCount].classList.remove("hide");
    }

};

//Quiz Creation
function quizCreator() {
    //randomly sort questions
    quizArray.sort(() => Math.random() - 0.5);
    //generate quiz
    for (let i of quizArray) {
        //randomly sort options
        i.listAnswer.sort(() => Math.random() - 0.5);
        //quiz card creation
        let div = document.createElement("div");
        div.classList.add("container-mid", "hide");
        //question number
        countOfQuestion.innerHTML = 1 + " of " + quizArray.length + " Question";
        //question
        let question_DIV = document.createElement("p");
        question_DIV.classList.add("question");
        question_DIV.innerHTML = i.content;
        div.appendChild(question_DIV);
        //options
        i.listAnswer.forEach((answer) => {
            const button = document.createElement("button");
            button.className = "option-div";
            button.id = answer.id;
            button.textContent = answer.content;
            button.onclick = () => checker(button, answer);

            div.appendChild(button);
        });

        quizContainer.appendChild(div);
    }
}

//Checker Function to check if option is correct or not
function checker( button ,userOption) {
    let userSolution = userOption.id; 
    let question = document.getElementsByClassName("container-mid")[questionCount];
    let options = question.querySelectorAll(".option-div");

    // if user clicked answer == correct option stored in object
    if (userSolution == quizArray[questionCount].isCorrectAnswer[0].id) {
        button.classList.add("correct");
        scoreCount++;
        console.log("correct");
        console.log(userOption);
    } else {
        button.classList.add("incorrect");
        // For marking the correct option
        options.forEach((element) => {
            if (element.id == quizArray[questionCount].isCorrectAnswer[0].id) {  
                element.classList.add("correct");
            }
        });
        console.log("incorrect");
    }

    //clear interval(stop timer)
    clearInterval(countdown);
    //disable all options
    options.forEach((element) => {
        element.disabled = true;
    });
}

//initial setup
function initial() {
    quizContainer.innerHTML = "";
    questionCount = 0;
    scoreCount = 0;
    count = 11;
    clearInterval(countdown);
    timerDisplay();
    quizCreator();
    quizDisplay(questionCount);
}

//when user click on start button
startButton.addEventListener("click", () => {
    startScreen.classList.add("hide");
    displayContainer.classList.remove("hide");
    initial();
});

//hide quiz and display start screen
window.onload = () => {
    startScreen.classList.remove("hide");
    displayContainer.classList.add("hide");
};