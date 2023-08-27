package com.tournament.tournament_app.controller;


import com.tournament.tournament_app.model.Match;
import com.tournament.tournament_app.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> getMatchLists() throws SQLException {
        return matchService.getMatchLists();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMatch(@PathVariable int id, @RequestBody Match matchToUpdate) {
        matchToUpdate.setId_match(id);
        try {
            matchService.updateMatch(matchToUpdate);
            return ResponseEntity.ok("Match updated successfully");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the match");
        }
    }

    @PostMapping
    public ResponseEntity<String> insertMatch(@RequestBody Match newMatch) {
        try {
            matchService.insertMatch(newMatch);
            return ResponseEntity.status(HttpStatus.CREATED).body("Match inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting match.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable int id) {
        try {
            matchService.deleteMatch(id);
            return ResponseEntity.ok("Match deleted successfully");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the match");
        }
    }

}
