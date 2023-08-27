package com.tournament.tournament_app.repository.interfaces;

import com.tournament.tournament_app.model.Match;
import com.tournament.tournament_app.model.Player;

import java.sql.SQLException;
import java.util.List;

public interface MatchInterface {
    List<Match> getMatchLists() throws SQLException;
    void insertMatch(Match match) throws SQLException;
    void updateMatch (Match match) throws  SQLException;
    void deleteMatch(int id) throws SQLException;
}
