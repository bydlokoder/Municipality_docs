package com.company.persistance.interfaces;

import com.company.entities.Answer;

public interface AnswerDBClassI {
    Answer getAnswer(int id);

    int createAnswer(Answer answer);

    int deleteAnswer(int id);

    int updateAnswer(Answer answer);
}
