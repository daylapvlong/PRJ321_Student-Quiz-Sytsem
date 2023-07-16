/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author admin's
 */
public class Quiz {
    private int quizId;
    private String quizName;
    private int numOfQuestions;
    private Date dateCreated;
    private Time timeLimit;
    
    public Quiz() {}

    public Quiz(int quizId, String quizName, int numOfQuestions, Date dateCreated, Time timeLimit) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.numOfQuestions = numOfQuestions;
        this.dateCreated = dateCreated;
        this.timeLimit = timeLimit;
    }


    // Getters and Setters
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Time getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Time timeLimit) {
        this.timeLimit = timeLimit;
    }   

    @Override
    public String toString() {
        return "Quiz{" + "quizId=" + quizId + ", quizName=" + quizName + ", numOfQuestions=" + numOfQuestions + ", dateCreated=" + dateCreated + ", timeLimit=" + timeLimit + '}';
    }
    
    
}
