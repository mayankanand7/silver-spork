package com.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.task.bean.UserBean;
import com.task.model.User;
import com.task.util.DBUtil;


public class UserDAO {

    // Fields


    // Constructor
    // ------------------------------------------------------------------------

    public UserDAO() {
        super();
    }


    // Methods
    // ------------------------------------------------------------------------

    public int create(final UserBean user) throws SQLException {
        final String insertSql =
                "INSERT INTO users (username, first_name, last_name, email, phone_no, is_active, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            // Set Parameters
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());

            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhoneNumber());

            pstmt.setBoolean(6, Boolean.TRUE);

            final long timeMillis = System.currentTimeMillis();
            pstmt.setLong(7, timeMillis);
            pstmt.setLong(8, timeMillis);

            // Execute Insert
            final int affectedRows = pstmt.executeUpdate();

            // Check if the insert was successful and retrieve the generated key
            if (affectedRows > 0) {
                // Get the generated keys
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // Retrieve the primary key (id) of the newly inserted user
                        return generatedKeys.getInt(1); // Assuming the primary key is an int
                    } else {
                        throw new SQLException("Failed to obtain generated key.");
                    }
                }
            } else {
                throw new SQLException("Insert failed, no rows affected.");
            }
        }
    }

    public void update(final int id, final UserBean user) throws SQLException {
        final String updateSql =
                "UPDATE users SET username = ?, first_name = ?, last_name = ?, email = ?, phone_no = ?, updated_assssssst = ?, is_active = ? WHERE id = ?";
        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
            // Set Parameters
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhoneNumber());
            pstmt.setLong(6, System.currentTimeMillis());

            // Execute Update
            pstmt.executeUpdate();
        }
    }

    public void delete(final int id) throws SQLException {
        final String deleteSql = "DELETE FROM users WHERE id = ?";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
            // Set Parameters
            pstmt.setInt(1, id);

            // Execute Delete
            pstmt.executeUpdate();
        }
    }

    public User getById(final int id) throws SQLException {
        final String selectSql = "SELECT * FROM users WHERE id = ?";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            // Set Parameters
            pstmt.setInt(1, id);

            // Execute Query
            final ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                final User user = new User();
                user.setId(rs.getInt("id"));
                user.setVersion(rs.getLong("version"));

                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));

                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phone_no"));

                user.setCreatedAt(rs.getLong("created_at"));
                user.setUpdatedAt(rs.getLong("updated_at"));

                user.setIsActive(rs.getBoolean("is_active"));

                return user;
            }
            return null;
        }
    }

    public List<User> getAll(final String query) throws SQLException {
        final String selectSql = "SELECT * FROM users";

        final List<User> users = new ArrayList<>();
        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(selectSql)) {

            // Execute Query
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final User user = new User();
                user.setId(rs.getInt("id"));
                user.setVersion(rs.getLong("version"));

                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));

                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phone_no"));

                user.setCreatedAt(rs.getLong("created_at"));
                user.setUpdatedAt(rs.getLong("updated_at"));

                user.setIsActive(rs.getBoolean("is_active"));

                users.add(user);
            }
        }

        return users;
    }

}
