package com.tournament.tournament_app.repository.dao;

import com.tournament.tournament_app.model.Player;
import com.tournament.tournament_app.repository.interfaces.PlayerInterface;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDAO implements PlayerInterface {
    private Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }


    //GET
    @Override
    public List<Player> getAllPlayers() throws SQLException {
        List<Player> allPlayers = new ArrayList<>();
        String sql = "SELECT * FROM player";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allPlayers, result);
            }
        }

        return allPlayers;
    }

    private void convertToList(List<Player> allPlayers, ResultSet result) throws SQLException {
        allPlayers.add(new Player(
                result.getInt("id"),
                result.getString("pseudo"),
                result.getDate("birthdate").toLocalDate(),
                result.getString("gender"),
                result.getString("ranking")
        ));
    }

    //UPDATE
    @Override
    public void updatePlayer(Player player) throws SQLException {
        String sql = "UPDATE player SET pseudo = ?, birthdate = ?, gender = ?, ranking = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, player.getPseudo());
            preparedStatement.setDate(2, java.sql.Date.valueOf(player.getBirthdate()));
            preparedStatement.setString(3, player.getGender());
            preparedStatement.setString(4, player.getRanking());
            preparedStatement.setInt(5, player.getId());

            preparedStatement.executeUpdate();
        }
    }


    //INSERT
    @Override
    public void insertPlayer(Player player) throws SQLException {
        String sql = "INSERT INTO player (id,pseudo, birthdate, gender, ranking) VALUES (?, ?, ?, ?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,player.getId());
            preparedStatement.setString(2, player.getPseudo());
            preparedStatement.setDate(3, java.sql.Date.valueOf(player.getBirthdate()));
            preparedStatement.setString(4, player.getGender());
            preparedStatement.setString(5, player.getRanking());

            preparedStatement.executeUpdate();
        }
    }

    //DELETE
    @Override
    public void deletePlayer(int id) throws SQLException {
        String sql = "DELETE FROM player WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

}
