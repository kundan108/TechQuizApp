/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.ArrayList;

/**
 *
 * @author kundankumargupta
 */
public class QuestionStore {

    ArrayList <Question> qustionList;

    public QuestionStore() {
        qustionList=new ArrayList<>();
    }
    public void addQuestion(Question q){
        qustionList.add(q);
    }
    public Question getQuestion(int pos){
        return qustionList.get(pos);
    }
    public void removeQuestion(int pos){
        qustionList.remove(pos);
    }
    public void setQestionAt(int pos,Question q){
        qustionList.add(pos, q);
    }
    public ArrayList<Question> getAllQuestions() {
        return qustionList;
    }
    public int getCount(){
        return qustionList.size();
    }

    @Override
    public String toString() {
        return "QuestionStore{" + "qustionList=" + qustionList + '}';
    }
}
