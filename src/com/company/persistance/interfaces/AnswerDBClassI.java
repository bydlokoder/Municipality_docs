package com.company.persistance.interfaces;

import com.company.entities.Answer;

import java.util.List;

public interface AnswerDBClassI {
    Answer getAnswer(int id);

    int createAnswer(Answer answer);

    int deleteAnswer(int id);

    int updateAnswer(Answer answer);

    List<Answer> getAnswerListByQuery(int queryId);
}
