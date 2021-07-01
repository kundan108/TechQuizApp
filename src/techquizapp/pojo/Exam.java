/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author kundankumargupta
 */
public class Exam {
    private String examId;
    private String language;
    private int totalQuestion;

    public Exam() {
    }

    public Exam(String examId, String language, int totalQuestion) {
        this.examId = examId;
        this.language = language;
        this.totalQuestion = totalQuestion;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }  
}
