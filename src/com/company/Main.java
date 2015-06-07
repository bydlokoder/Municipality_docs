package com.company;

import com.company.entities.Answer;
import com.company.persistance.AnswerDBClassImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    private static AnswerDBClassImpl answerDBClass = new AnswerDBClassImpl();

    public static void main(String[] args) {
        Answer answer = new Answer(1, "YOU SHALLN'T PASS", Date.valueOf(LocalDate.now()));
        try {
            answerDBClass.createAnswer(answer);
        } catch (SQLException e) {
            System.out.println("Error :( \n" + e.getMessage());
        }
    }
}
