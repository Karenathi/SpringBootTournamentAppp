package com.tournament.tournament_app.repository.dao;

import com.tournament.tournament_app.model.Match;
import com.tournament.tournament_app.model.Player;
import com.tournament.tournament_app.repository.interfaces.MatchInterface;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchDAO implements MatchInterface {
    private Connection connection;

    public MatchDAO(Connection connection) {
        this.connection = connection;
    }
    //GET
    @Override
    public List<Match> getMatchLists() throws SQLException {
        List<Match> allMatches = new ArrayList<>();
        String sql = "SELECT id_match, match_date, match_time, score, results FROM match";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allMatches, result);
            }
        }

        return allMatches;
    }

    //INSERT
    @Override
    public void insertMatch(Match match) throws SQLException {
        String sql = "INSERT INTO match (id_match,match_date, match_time, score, results) VALUES (?, ?, ?, ?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,match.getId_match());
            preparedStatement.setDate(2, java.sql.Date.valueOf(match.getMatch_date()));
            preparedStatement.setTime(3, java.sql.Time.valueOf(match.getMatch_time()));
            preparedStatement.setString(4, match.getScore());
            preparedStatement.setString(5, match.getResults());

            preparedStatement.executeUpdate();
        }
    }


    //UPDATE
    @Override
    public void updateMatch(Match match) throws SQLException {
        String sql = "UPDATE match SET match_date = ?, match_time = ?, score = ?, results = ? WHERE id_match = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(match.getMatch_date()));
            preparedStatement.setTime(2, java.sql.Time.valueOf(match.getMatch_time()));
            preparedStatement.setString(3, match.getScore());
            preparedStatement.setString(4, match.getResults());
            preparedStatement.setInt(5, match.getId_match());

            preparedStatement.executeUpdate();
        }
    }


    //DELETE
    @Override
    public void deleteMatch(int id) throws SQLException {
        String sql = "DELETE FROM match WHERE id_match = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    private void convertToList(List<Match> allMatches, ResultSet result) throws SQLException {
        LocalDate matchDate = result.getDate("match_date") != null ? result.getDate("match_date").toLocalDate() : null;
        LocalTime matchTime = result.getTime("match_time") != null ? result.getTime("match_time").toLocalTime() : null;

        allMatches.add(new Match(
                result.getInt("id_match"),
                matchDate,
                matchTime,
                result.getString("score"),
                result.getString("results")
        ));
    }

}
