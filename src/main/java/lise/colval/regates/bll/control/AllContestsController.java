/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lise.colval.regates.bll.control;

import java.util.List;
import lise.colval.regates.bll.model.competition.Contest;
import lise.colval.regates.dal.Repository;

/**
 *
 * @author Vincent Laude
 */
public class AllContestsController {

    public Contest findContestById(int id) {
        return Repository.getInstance().findContestById(id);
    }

    public List<Contest> getAllContests() {
        return Repository.getInstance().getAllContests();
    }
}
