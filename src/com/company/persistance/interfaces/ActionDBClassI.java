package com.company.persistance.interfaces;

import com.company.entities.Action;

public interface ActionDBClassI {
    Action getAction(int id);

    int createAction(Action action);

    int deleteAction(int id);

    int updateAction(Action action);
}
