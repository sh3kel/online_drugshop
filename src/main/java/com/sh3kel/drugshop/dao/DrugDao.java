package com.sh3kel.drugshop.dao;

import com.sh3kel.drugshop.entity.Drug;
import com.sh3kel.drugshop.util.ConnectionManager;

import java.sql.*;
import java.time.Instant;

public class DrugDao{
    public static Drug getById(int id) {
        String sql = """
                        SELECT *
                         FROM drugs WHERE id = ?;
                     """;
        Drug drug = null;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                drug = new Drug(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("need_prescription"),
                        resultSet.getDate("release_date").toLocalDate(),
                        resultSet.getDate("expiration_date").toLocalDate(),
                        resultSet.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return drug;
    }

    public static boolean create(Drug drug) {
        String sql = """
                        INSERT INTO drugs (title, description, need_prescription, release_date, expiration_date, quantity)
                        VALUES ( ?, ?, ?, ?, ?, ?);
                     """;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, drug.getTitle());
            preparedStatement.setString(2, drug.getDescription());
            preparedStatement.setBoolean(3, drug.isNeedPrescription());
            preparedStatement.setDate(4, Date.valueOf(drug.getReleaseDate()));
            preparedStatement.setDate(5, Date.valueOf(drug.getExpirationDate()));
            preparedStatement.setInt(6, drug.getQuantity());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updateById(int id, Drug drug) {
        String sql = """
                    UPDATE drugs
                    SET title = ?,
                        description = ?,
                        need_prescription = ?,
                        release_date = ?,
                        expiration_date = ?,
                        quantity = ?
                    WHERE id = ?
                """;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, drug.getTitle());
            preparedStatement.setString(2, drug.getDescription());
            preparedStatement.setBoolean(3, drug.isNeedPrescription());
            preparedStatement.setDate(4, Date.valueOf(drug.getReleaseDate()));
            preparedStatement.setDate(5, Date.valueOf(drug.getExpirationDate()));
            preparedStatement.setInt(6, drug.getQuantity());
            preparedStatement.setInt(7, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deleteByID(int id) {
        String sql = """
                    DELETE FROM drugs
                    WHERE id = ?;
                """;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
