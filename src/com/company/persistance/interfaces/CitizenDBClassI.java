package com.company.persistance.interfaces;

import com.company.entities.Citizen;

public interface CitizenDBClassI {
    Citizen getCitizen(int id);

    int createCitizen(Citizen citizen);

    int deleteCitizen(int id);

    int updateCitizen(Citizen citizen);
}
