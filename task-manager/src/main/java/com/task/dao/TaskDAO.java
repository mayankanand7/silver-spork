package com.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.task.bean.TaskBean;
import com.task.model.Task;
import com.task.util.DBUtil;


public class TaskDAO {


    // Fields


    // Constructor
    // ------------------------------------------------------------------------

    public TaskDAO() {
        super();
    }


    // Methods
    // ------------------------------------------------------------------------

    public int create(final TaskBean task) throws SQLException {
        final String insertSql =
                "INSERT INTO tasks (user_id, parent_id, title, description, is_completed, is_active, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            // Set Parameters
            pstmt.setInt(1, task.getUserId());
            pstmt.setInt(2, task.getParentId());

            pstmt.setString(3, task.getTitle());
            pstmt.setString(4, task.getDescription());

            pstmt.setBoolean(5, Boolean.FALSE);
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

    public void update(final int id, final TaskBean task) throws SQLException {
        final String updateSql =
                "UPDATE tasks SET user_id=?, parent_id=?, title=?, description=?, is_completed=?, is_active=?, updated_at=? WHERE id = ?";
        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
            // Set Parameters
            pstmt.setInt(1, task.getUserId());
            pstmt.setInt(2, task.getParentId());

            pstmt.setString(3, task.getTitle());
            pstmt.setString(4, task.getDescription());

            pstmt.setBoolean(5, task.getIsCompleted());
            pstmt.setBoolean(6, task.getIsActive());

            final long timeMillis = System.currentTimeMillis();
            pstmt.setLong(7, timeMillis);


            // Execute Update
            pstmt.executeUpdate();
        }
    }

    public void delete(final int id) throws SQLException {
        final String deleteSql = "DELETE FROM tasks WHERE id = ?";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
            // Set Parameters
            pstmt.setInt(1, id);

            // Execute Delete
            pstmt.executeUpdate();
        }
    }

    public Task getById(final int id) throws SQLException {
        final String selectSql = "SELECT * FROM tasks WHERE id = ?";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            // Set Parameters
            pstmt.setInt(1, id);

            // Execute Query
            final ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                final Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setVersion(rs.getLong("version"));

                task.setUserId(rs.getInt("user_id"));
                task.setParentId(rs.getInt("parent_id"));

                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));

                task.setIsCompleted(rs.getBoolean("is_completed"));
                task.setIsActive(rs.getBoolean("is_active"));

                task.setCreatedAt(rs.getLong("created_at"));
                task.setUpdatedAt(rs.getLong("updated_at"));

                task.setIsActive(rs.getBoolean("is_active"));

                return task;
            }
            return null;
        }
    }

    public List<Task> getAll(final String query) throws SQLException {
        final String selectSql = "SELECT * FROM tasks";

        final List<Task> tasks = new ArrayList<>();
        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(selectSql)) {

            // Execute Query
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setVersion(rs.getLong("version"));

                task.setUserId(rs.getInt("user_id"));
                task.setParentId(rs.getInt("parent_id"));

                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));

                task.setIsCompleted(rs.getBoolean("is_completed"));
                task.setIsActive(rs.getBoolean("is_active"));

                task.setCreatedAt(rs.getLong("created_at"));
                task.setUpdatedAt(rs.getLong("updated_at"));

                task.setIsActive(rs.getBoolean("is_active"));

                tasks.add(task);
            }
        }

        return tasks;
    }

}
