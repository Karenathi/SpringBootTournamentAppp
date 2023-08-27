package com.tournament.tournament_app.repository.interfaces;

import com.tournament.tournament_app.model.Tournament;

import java.sql.SQLException;
import java.util.List;

public interface TournamentInterface {
   public List<Tournament> TournamentInfo() throws SQLException;
   void updateTournament( Tournament tournament) throws  SQLException;
   void insertTournament(Tournament tournament) throws SQLException;
   void deleteTournament(int id) throws SQLException;
}

