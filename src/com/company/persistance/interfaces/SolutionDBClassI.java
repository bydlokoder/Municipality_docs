package com.company.persistance.interfaces;

import com.company.entities.Solution;

public interface SolutionDBClassI {
    Solution getSolution(int id);

    int createSolution(Solution solution);

    int deleteSolution(int id);

    int updateSolution(Solution solution);

    Solution getSolutionByQuery(int queryId);
}
