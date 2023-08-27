package com.tournament.tournament_app.service;

import com.tournament.tournament_app.model.Tournament;
import com.tournament.tournament_app.repository.dao.TournamentDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TournamentService {
    private TournamentDAO tournamentdao;

    //Get
    public TournamentService(TournamentDAO tournamentdao){
        this.tournamentdao = tournamentdao;
    }

    public List<Tournament> TournamentInfo() throws SQLException {
        return tournamentdao.TournamentInfo();
    }

    //Put
    public void updateTournament(Tournament tournament) throws SQLException {
        tournamentdao.updateTournament(tournament);
    }

    // Insert
    public void insertTournament(Tournament tournament) throws SQLException {
        tournamentdao.insertTournament(tournament);
    }

   //Delete
   public void deleteTournament(int id) throws SQLException {
       tournamentdao.deleteTournament(id);
   }


}

