package com.tournament.tournament_app.controller;

import com.tournament.tournament_app.model.Tournament;
import com.tournament.tournament_app.service.TournamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class TournamentController {
    private TournamentService tournamentservice;

    public TournamentController(TournamentService tournamentservice){
        this.tournamentservice = tournamentservice;
    }

    @GetMapping("/tournaments")
    public List<Tournament> TournamentInfo() throws SQLException{
        return tournamentservice.TournamentInfo();
    }

    @PutMapping("/update_tournaments/{id}")
    public ResponseEntity<String> updateTournament(@PathVariable int id, @RequestBody Tournament tournament) throws SQLException {
        tournament.setId_tournament(id);
        tournamentservice.updateTournament(tournament);
        return ResponseEntity.ok("Tournament updated successfully.");
    }

    @PostMapping("/insert_tournament")
    public ResponseEntity<String> insertTournament(@RequestBody Tournament tournament) throws SQLException {
        tournamentservice.insertTournament(tournament);
        return ResponseEntity.ok("Tournament inserted successfully.");
    }

    @DeleteMapping("/delete_tournament/{id}")
    public ResponseEntity<String> deleteTournament(@PathVariable int id) throws SQLException {
        tournamentservice.deleteTournament(id);
        return ResponseEntity.ok("Tournament deleted successfully.");
    }

}
