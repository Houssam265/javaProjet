package com.projet.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDonnees {
    private static final String URL = "jdbc:sqlite:scores.db";

    public BaseDeDonnees() {
        initialiserBDD();
    }

    private void initialiserBDD() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS scores (" +
                    "id INTEGER PRIMARY KEY," +
                    "nom_joueur TEXT," +
                    "score INTEGER," +
                    "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveScore(int score) {
        String sql = "INSERT INTO scores(nom_joueur, score) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "JoueurAnonyme");
            pstmt.setInt(2, score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> ChargerScore() {
        List<Integer> scores = new ArrayList<>();
        String sql = "SELECT score FROM scores ORDER BY score DESC LIMIT 10";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                scores.add(rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }
}