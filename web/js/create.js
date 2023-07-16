var parentQuestion = document.getElementById('form');
var parentAnswer = document.getElementById('createTable');

function duplicateQuestion() {


    const node = parentQuestion.getElementsByClassName("questionContainer")[0];

    if (node) {
        const clone = node.cloneNode(true);
        parentQuestion.insertBefore(clone, node);
    } else {
        console.error("The reference node is not a child of the parent node. The parent node is: ", node.parentNode);
    }
}

function duplicateAnswer() {
    const node = parentAnswer.querySelector(".formAnswer");

    if (node) {
        const clone = node.cloneNode(true);
        parentAnswer.insertBefore(clone, node);
    } else {
        console.error("The reference node is not a child of the parent node. The parent node is: ", node.parentNode);
    }
}

function getAnswerCount() {
    var parent = document.getElementById("questionContainer");
    var nodesSameClass = parent.getElementsByClassName("formAnswer");
    console.log(nodesSameClass.length);
}

function deleteQuestion() {
    var parent = document.getElementById("wrapper");
    var nodesSameClass = parent.getElementsByClassName("questionContainer");
    // when there is only one question left, the delete button will be disabled
    if (nodesSameClass.length > 1) {
        const element = document.getElementById("createTable");
        element.remove();
    }
}

function deleteAnswer() {
    var parent = document.getElementById("questionContainer");
    var nodesSameClass = parent.getElementsByClassName("formAnswer");
    // Ensure that there is at least one answer before deleting
    if (nodesSameClass.length > 1) {
        var element = document.getElementById("createAnswer");

        // Check if the element exists before removing it
        if (element) {
            element.remove();
        } else {
            console.error("Element with ID 'createAnswer' not found.");
        }
    }
}