package com.company.persistance.interfaces;

import com.company.entities.Citizen;

public interface CitizenDBClassI {
    void getAnswer(int id);

    void createAnswer(Citizen citizen);

    void deleteAnswer(int id);

    void updateAnswer(Citizen citizen);
}
