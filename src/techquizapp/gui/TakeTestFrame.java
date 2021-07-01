/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import techquizapp.dao.PerformanceDAO;
import techquizapp.dao.QuestionDAO;
import techquizapp.pojo.Answer;
import techquizapp.pojo.AnswerStore;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Performance;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author kundankumargupta
 */
public class TakeTestFrame extends javax.swing.JFrame {

    /**
     * Creates new form TakeTestFrame
     */
    private Answer newAnswer;
    private Answer answer;
    private Exam exam;
    private QuestionStore qstore;
    private AnswerStore astore;
    private int qno,pos=0;
    Color old;
    Font fOld;
    TimerScreen ts;
    public TakeTestFrame() {
        initComponents();
        setLocationRelativeTo(null);
        lblUser.setText("Hello "+UserProfile.getUsername());
        old=lblLogout.getForeground();
        fOld=lblLogout.getFont();
        qstore = new QuestionStore();
        astore = new AnswerStore();
        qno = 1;
        ts = new TimerScreen();
        ts.start();
    }

    TakeTestFrame(Exam exam) {
        this();
        this.exam=exam;
        lblTitle.setText(exam.getLanguage().toUpperCase()+" PAPER");
        loadQuestion();
        showQuestion();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblqno = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        jrbOption1 = new javax.swing.JRadioButton();
        jrbOption2 = new javax.swing.JRadioButton();
        jrbOption3 = new javax.swing.JRadioButton();
        jrbOption4 = new javax.swing.JRadioButton();
        lblTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblqno.setForeground(new java.awt.Color(204, 204, 0));
        lblqno.setText("Question no :");

        lblUser.setForeground(new java.awt.Color(204, 204, 0));

        lblLogout.setForeground(new java.awt.Color(204, 204, 0));
        lblLogout.setText("logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/kundankumargupta/NetBeansProjects/TechQuizApp/src/techquizapp/images/good luck2.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setForeground(new java.awt.Color(204, 204, 0));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setForeground(new java.awt.Color(204, 204, 0));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setForeground(new java.awt.Color(204, 204, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setForeground(new java.awt.Color(204, 204, 0));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        txtQuestion.setEditable(false);
        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        lblTitle.setFont(new java.awt.Font("Al Nile", 1, 19)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 204, 0));

        buttonGroup1.add(jrbOption1);
        jrbOption1.setForeground(new java.awt.Color(204, 204, 0));
        jrbOption1.setText("jRadioButton1");

        buttonGroup1.add(jrbOption2);
        jrbOption2.setForeground(new java.awt.Color(204, 204, 0));
        jrbOption2.setText("jRadioButton1");

        buttonGroup1.add(jrbOption3);
        jrbOption3.setForeground(new java.awt.Color(204, 204, 0));
        jrbOption3.setText("jRadioButton1");

        buttonGroup1.add(jrbOption4);
        jrbOption4.setForeground(new java.awt.Color(204, 204, 0));
        jrbOption4.setText("jrbOption4");

        lblTimer.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnNext)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnPrevious)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDone))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jrbOption2)
                                        .addComponent(jrbOption4))
                                    .addGap(20, 20, 20))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(lblqno)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jrbOption3)
                                .addComponent(jrbOption1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogout)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblqno))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbOption1)
                    .addComponent(jrbOption2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbOption3)
                    .addComponent(jrbOption4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDone)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnCancel))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        ts.stop();
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null){
            Question question=qstore.getQuestion(pos);
            String correctAnswer = question.getCorrectAnswer();
            newAnswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
            
            answer=astore.getAnswerByQno(qno);
            if(answer==null){
                astore.addAnswer(newAnswer);
            }else{
                if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                    int apos=astore.removeAnswer(answer);
                    astore.setAnswerAt(apos, newAnswer);
                }
            }
        }

        int right=0,wrong=0;
        for(Question question : qstore.getAllQuestions()){
            int qno=question.getQno();
            answer=astore.getAnswerByQno(qno);
            if(answer==null)
                continue;
            else{
                String chosenAnswer1=answer.getChosenAnswer();
                String correctAnswer=answer.getCorrectAnswer();
                if(chosenAnswer1.equals(correctAnswer))
                    right++;
                else
                    wrong++;
            }
        }
        String reportCard="Total Questions:"+qstore.getCount();
        reportCard+="\nRight Answer:"+right;
        reportCard+="\nWrong Answer:"+wrong;
        reportCard+="\nUnAttempted :"+(qstore.getCount()-(right+wrong));
        JOptionPane.showMessageDialog(null,reportCard,"Your Result!",JOptionPane.INFORMATION_MESSAGE);
        try {

            Performance  performance = new Performance(UserProfile.getUsername(),exam.getExamId(),right,wrong,(qstore.getCount()-(right+wrong)),(double)right/qstore.getCount()*100,exam.getLanguage());
            PerformanceDAO.addPerformance(performance);
            JOptionPane.showMessageDialog(null, "Your performance has been added successfully!","Performace Added",JOptionPane.INFORMATION_MESSAGE);
            ChooosePaperFrame chooosePaperFrame= new ChooosePaperFrame();
            chooosePaperFrame.setVisible(true);
            this.dispose();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in storing the data","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ChooosePaperFrame chooosePaperFrame = new ChooosePaperFrame();
        chooosePaperFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null){
            Question question=qstore.getQuestion(pos);
            String correctAnswer = question.getCorrectAnswer();
            newAnswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
            
            answer=astore.getAnswerByQno(qno);
            if(answer==null){
                astore.addAnswer(newAnswer);
            }else{
                    if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                    int apos=astore.removeAnswer(answer);
                    astore.setAnswerAt(apos, newAnswer);
                }
            }
        }
        pos--;
        if(pos<0){
            pos=qstore.getCount()-1;
        }
        qno--;
        if(qno<=0){
            qno=qstore.getCount();
        }
        lblqno.setText("Question no :"+qno);
        showQuestion();

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null){
            Question question=qstore.getQuestion(pos);
            System.out.println(question);
            String correctAnswer = question.getCorrectAnswer();
            newAnswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
            
            answer=astore.getAnswerByQno(qno);
            if(answer==null){
                astore.addAnswer(newAnswer);
            }else{
                if(newAnswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                    int apos=astore.removeAnswer(answer);
                    astore.setAnswerAt(apos, newAnswer);
                }
            }
        }
        pos++;
        if(pos>=qstore.getCount()){
            pos=0;
        }
        qno++;
        if(qno>qstore.getCount()){
            qno=1;
        }
        lblqno.setText("Question no :"+qno);
        showQuestion();   
    }//GEN-LAST:event_btnNextActionPerformed

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        lblLogout.setForeground(Color.WHITE);
        Font f= new Font("Tahoma",Font.ITALIC,13);
        lblLogout.setFont(f);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        lblLogout.setForeground(old);
        //Font f= new Font("Tahoma",Font.BOLD,13);
        lblLogout.setFont(fOld);
    }//GEN-LAST:event_lblLogoutMouseExited

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void loadQuestion(){
        try{
            ArrayList<Question> questionList = QuestionDAO.getQuestionByExamId(exam.getExamId());
            for(Question q:questionList){
                qstore.addQuestion(q);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error in loading the question","Error",JOptionPane.ERROR_MESSAGE);    
        }
    }    
    private void showQuestion(){
        Question q=qstore.getQuestion(pos);
        buttonGroup1.clearSelection();
        txtQuestion.setText(q.getQuestion());
        jrbOption1.setText(q.getAnswer1());
        jrbOption2.setText(q.getAnswer2());
        jrbOption3.setText(q.getAnswer3());
        jrbOption4.setText(q.getAnswer4()); 
        answer=astore.getAnswerByQno(qno);
        if(answer==null)
            return;
        System.out.println(answer);
        String chosenAnswer=answer.getChosenAnswer();
        switch(chosenAnswer){
            case "Answer1":
                jrbOption1.setSelected(true);
                break;
            case "Answer2":
                jrbOption2.setSelected(true);
                break;
            case "Answer3":
                jrbOption3.setSelected(true);
                break;
            case "Answer4":
                jrbOption4.setSelected(true);
                break;
        }
        
    }
    
    class TimerScreen extends Thread
    {
        public void run()
        {
            int count=1;
            Random r = new Random();
            int timer=1*60;
            long delay = timer*1000;
            do{
                try{
                    int minute = timer/60;
                    int seconds=timer%60;
                    lblTimer.setText(minute+" m : "+seconds+" s");
                    Thread.sleep(1000);
                    timer=timer-1;
                    delay=delay-1000;
                }catch(InterruptedException ex){
                    JOptionPane.showMessageDialog(null, "Error in Take Test Frame", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }while(delay!=0);
            JOptionPane.showMessageDialog(null, "Times Up!\n Thanks for giving the test","Test Complete",JOptionPane.INFORMATION_MESSAGE);
            btnDone.doClick();
        }

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblqno;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables

    private String getUserAnswer() {
        if(jrbOption1.isSelected())
            return "Answer1";
        else if(jrbOption2.isSelected())
            return "Answer2";
        else if(jrbOption3.isSelected())
            return "Answer3";
        else if(jrbOption4.isSelected())
            return "Answer4";
        else
            return null;
    }
}