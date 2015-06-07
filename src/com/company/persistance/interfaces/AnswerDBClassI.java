package com.company.persistance.interfaces;

import com.company.entities.Answer;

import java.sql.SQLException;

public interface AnswerDBClassI {
    Answer getAnswer(int id) throws SQLException;

    int createAnswer(Answer answer) throws SQLException;

    void deleteAnswer(int id);

    void updateAnswer(Answer answer);
}
