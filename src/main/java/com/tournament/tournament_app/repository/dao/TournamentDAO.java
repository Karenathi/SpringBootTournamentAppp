package com.tournament.tournament_app.repository.dao;

import com.tournament.tournament_app.model.Tournament;
import com.tournament.tournament_app.repository.interfaces.TournamentInterface;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TournamentDAO implements TournamentInterface {
    private Connection connection;

    public TournamentDAO(Connection connection){
        this.connection = connection;
    }



    //GET
    @Override
    public List<Tournament> TournamentInfo() throws SQLException{
        List<Tournament>allTournament = new ArrayList<>();
        String sql = "SELECT * FROM tournament";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                convertToList(allTournament, result);
            }
        }
        return allTournament;
    }

    private void convertToList(List<Tournament> allTournament, ResultSet result) throws SQLException {
        allTournament.add(new Tournament(
                result.getInt("id_tournament"),
                result.getString("tournament_name"),
                result.getDate("date_of_start").toLocalDate(),
                result.getDate("date_of_end").toLocalDate(),
                result.getFloat("duration_hours")
        ));
    }

    //UPDATE
    @Override
    public void updateTournament(Tournament tournament) throws SQLException {
        String sql = "UPDATE tournament SET id_tournament = ?, tournament_name = ?, date_of_start = ? , date_of_end = ?, duration_hours = ? WHERE id_tournament = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,tournament.getTournament_name());
            preparedStatement.setDate(2, Date.valueOf(tournament.getDate_of_start()));
            preparedStatement.setDate(3, Date.valueOf(tournament.getDate_of_end()));
            preparedStatement.setFloat(4, tournament.getDuration_hours());
            preparedStatement.setInt(5,tournament.getId_tournament());
        }
    }


    //Insert
    @Override
    public void insertTournament(Tournament tournament) throws SQLException {
        String sql = "INSERT INTO tournament (id_tournament, tournament_name, date_of_start, date_of_end, duration_hours) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, tournament.getId_tournament());
            preparedStatement.setString(2, tournament.getTournament_name());
            preparedStatement.setDate(3, Date.valueOf(tournament.getDate_of_start()));
            preparedStatement.setDate(4, Date.valueOf(tournament.getDate_of_end()));
            preparedStatement.setFloat(5, tournament.getDuration_hours());

            preparedStatement.executeUpdate();
        }
    }

    //Delete
    @Override
    public void deleteTournament(int id) throws SQLException {
        String sql = "DELETE FROM tournament WHERE id_tournament = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }



}
