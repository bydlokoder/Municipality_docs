package com.company;

import com.company.entities.Answer;
import com.company.entities.Citizen;
import com.company.entities.Query;
import com.company.persistance.AnswerDBClassImpl;
import com.company.persistance.CitizenDBClassImpl;
import com.company.persistance.QueryDBClassImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static AnswerDBClassImpl answerDBClass = new AnswerDBClassImpl();
    private static CitizenDBClassImpl citizenDBClass = new CitizenDBClassImpl();
    private static QueryDBClassImpl queryDBClass = new QueryDBClassImpl();

    public static void main(String[] args) {
        Answer answer = new Answer(1, "YOU SHALLN'T PASS", Date.valueOf(LocalDate.now()));
        Citizen citizen = new Citizen("Lapshov", "Ivan", "123455432", "Moscow");
        List<Query> list = queryDBClass.getQueryListForCitizen(10);
        list.size();
        //citizenDBClass.deleteCitizen(1001);

    }
}
