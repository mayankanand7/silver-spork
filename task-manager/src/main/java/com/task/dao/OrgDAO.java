package com.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.task.bean.OrgBean;
import com.task.model.Org;
import com.task.util.DBUtil;


public class OrgDAO {

    // Fields


    // Constructor
    // ------------------------------------------------------------------------

    public OrgDAO() {
        super();
    }


    // Methods
    // ------------------------------------------------------------------------

    public int create(final OrgBean org) throws SQLException {
        final String insertSql =
                "INSERT INTO orgs (name, description, address_line_1, address_line_2, city, state, zipcode, country, phone_no, email, created_at, updated_at, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            // Set Parameters
            pstmt.setString(1, org.getName());
            pstmt.setString(2, org.getDescription());

            pstmt.setString(3, org.getAddressLine1());
            pstmt.setString(4, org.getAddressLine2());
            pstmt.setString(5, org.getCity());
            pstmt.setString(6, org.getState());
            pstmt.setString(6, org.getZipCode());
            pstmt.setString(6, org.getCountry());

            pstmt.setString(6, org.getPhoneNumber());
            pstmt.setString(6, org.getEmail());

            final long timeMillis = System.currentTimeMillis();
            pstmt.setLong(7, timeMillis);
            pstmt.setLong(8, timeMillis);

            pstmt.setBoolean(6, Boolean.TRUE);

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

    public void update(final int id, final OrgBean org) throws SQLException {
        final String updateSql =
                "UPDATE orgs SET name=?, description=?, address_line_1=?, address_line_2=?, city=?, state=?, zipcode=?, country=?, phone_no=?, email=?, updated_at=?, is_active=? WHERE id = ?";
        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
            // Set Parameters
            pstmt.setString(1, org.getName());
            pstmt.setString(2, org.getDescription());

            pstmt.setString(3, org.getAddressLine1());
            pstmt.setString(4, org.getAddressLine2());
            pstmt.setString(5, org.getCity());
            pstmt.setString(6, org.getState());
            pstmt.setString(6, org.getZipCode());
            pstmt.setString(6, org.getCountry());

            pstmt.setString(6, org.getPhoneNumber());
            pstmt.setString(6, org.getEmail());

            pstmt.setLong(7, System.currentTimeMillis());

            pstmt.setBoolean(6, Boolean.TRUE);
            // Execute Update
            pstmt.executeUpdate();
        }
    }

    public void delete(final int id) throws SQLException {
        final String deleteSql = "DELETE FROM orgs WHERE id = ?";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
            // Set Parameters
            pstmt.setInt(1, id);

            // Execute Delete
            pstmt.executeUpdate();
        }
    }

    public Org getById(final int id) throws SQLException {
        final String selectSql = "SELECT * FROM orgs WHERE id = ?";

        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            // Set Parameters
            pstmt.setInt(1, id);

            // Execute Query
            final ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                final Org org = new Org();
                org.setId(rs.getInt("id"));
                org.setVersion(rs.getLong("version"));

                org.setName(rs.getString("name"));
                org.setDescription(rs.getString("description"));

                org.setAddressLine1(rs.getString("address_line_1"));
                org.setAddressLine2(rs.getString("address_line_2"));
                org.setCity(rs.getString("city"));
                org.setState(rs.getString("state"));
                org.setZipCode(rs.getString("zipcode"));
                org.setCountry(rs.getString("country"));

                org.setPhoneNumber(rs.getString("phone_no"));
                org.setEmail(rs.getString("email"));

                org.setCreatedAt(rs.getLong("created_at"));
                org.setUpdatedAt(rs.getLong("updated_at"));

                org.setIsActive(rs.getBoolean("is_active"));

                return org;
            }
            return null;
        }
    }

    public List<Org> getAll(final String query) throws SQLException {
        final String selectSql = "SELECT * FROM org";

        final List<Org> orgs = new ArrayList<>();
        try (final Connection conn = DBUtil.getConnection();
                final PreparedStatement pstmt = conn.prepareStatement(selectSql)) {

            // Execute Query
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final Org org = new Org();
                org.setId(rs.getInt("id"));
                org.setVersion(rs.getLong("version"));

                org.setName(rs.getString("name"));
                org.setDescription(rs.getString("description"));

                org.setAddressLine1(rs.getString("address_line_1"));
                org.setAddressLine2(rs.getString("address_line_2"));
                org.setCity(rs.getString("city"));
                org.setState(rs.getString("state"));
                org.setZipCode(rs.getString("zipcode"));
                org.setCountry(rs.getString("country"));

                org.setPhoneNumber(rs.getString("phone_no"));
                org.setEmail(rs.getString("email"));

                org.setCreatedAt(rs.getLong("created_at"));
                org.setUpdatedAt(rs.getLong("updated_at"));

                org.setIsActive(rs.getBoolean("is_active"));

                orgs.add(org);
            }
        }

        return orgs;
    }

}
