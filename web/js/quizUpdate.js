// create a function that loop through the questions and answers and count the question number

window.onload = function countQuestion() {
    var questionNumber = 0;
    var questionList = document.getElementsByClassName("container-mid");
    var questionNumberElements = document.getElementsByClassName("quesnumber");

    for (var i = 0; i < questionList.length; i++) {
        questionNumber++;
        questionNumberElements[i].innerHTML = "Question " + questionNumber;
    }
}





