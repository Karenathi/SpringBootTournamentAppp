package com.tournament.tournament_app.service;

import com.tournament.tournament_app.model.Match;
import com.tournament.tournament_app.repository.interfaces.MatchInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MatchService {
    private final MatchInterface matchDao;

    @Autowired
    public MatchService(MatchInterface matchDao) {
        this.matchDao = matchDao;
    }

    //GET
    public List<Match> getMatchLists() throws SQLException {
        return matchDao.getMatchLists();
    }

    //INSERT
    public void insertMatch(Match match) throws SQLException {
        matchDao.insertMatch(match);
    }

    //UPDATE
    public void updateMatch(Match match) throws SQLException {
        matchDao.updateMatch(match);
    }

    //DELETE
    public void deleteMatch(int id) throws SQLException {
        matchDao.deleteMatch(id);
    }
}
