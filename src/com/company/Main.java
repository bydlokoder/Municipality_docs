package com.company;

import com.company.entities.Answer;
import com.company.entities.Citizen;
import com.company.persistance.AnswerDBClassImpl;
import com.company.persistance.CitizenDBClassImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    private static AnswerDBClassImpl answerDBClass = new AnswerDBClassImpl();
    private static CitizenDBClassImpl citizenDBClass = new CitizenDBClassImpl();

    public static void main(String[] args) {
        Answer answer = new Answer(1, "YOU SHALLN'T PASS", Date.valueOf(LocalDate.now()));
        Citizen citizen = new Citizen("Lapshov", "Ivan", "123455432", "Moscow");
        try {
            //answerDBClass.createAnswer(answer);
            //citizenDBClass.createCitizen(citizen);
            Citizen citizen1 = citizenDBClass.getCitizen(1001);
            citizen1.getLastName();
            citizenDBClass.deleteCitizen(1001);
        } catch (SQLException e) {
            System.out.println("Error :( \n" + e.getMessage());
        }
    }
}
