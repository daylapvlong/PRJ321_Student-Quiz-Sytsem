let params = new URL(document.location).searchParams;

//value
let questionContent =  document.querySelector('.option-div-question').value;
let questionId = parseInt(params.get("questionid"));
let answerDataList = [];

// Get all the answer elements with the class "formAnswer"
let answerElements = document.getElementsByClassName('formAnswer');

// Iterate over the answer elements and construct the answer objects
for (let i = 0; i < answerElements.length; i++) {
    let answerElement = answerElements[i];

    // Get the content and isCorrectAnswer values from the corresponding elements
    let content = answerElement.querySelector('.option-div-answer').innerText;
    let isCorrectAnswer = answerElement.querySelector('.radio').checked;

    // Create an answer object and add it to the answerDataList array
    let answer = {
        content: content,
        isCorrectAnswer: isCorrectAnswer
    };
    answerDataList.push(answer);
}

console.log(questionContent);
console.log(questionId);
console.log(answerDataList);

// const postData = {
//     questionContent: questionContent,
//     questionId: questionId,
//     answerDataList: answerDataList
// };
//
// fetch('/changeQuizQuestion', {
//     method: 'POST',
//     headers: {
//         'Content-Type': 'application/json'
//     },
//     body: JSON.stringify(postData)
// })
//     .then(response => response.text())
//     .then(data => {
//         console.log(data); // Log the response from the server
//     })
//     .catch(error => {
//         console.error('Error:', error);
//     });