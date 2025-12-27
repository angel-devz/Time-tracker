// THIS CODE IS WRITTEN BY ANGEL

package com.timetracker.dao;

import com.timetracker.model.TimeLog;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeLogDAO {

    public void addTimeLog(TimeLog t) throws SQLException {
        String sql = "INSERT INTO time_logs (user_id, task, start_time, end_time, hours, date_logged, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, t.getUserId());
            ps.setString(2, t.getTask());
            ps.setTimestamp(3, Timestamp.valueOf(t.getStartTime()));
            ps.setTimestamp(4, Timestamp.valueOf(t.getEndTime()));
            ps.setDouble(5, t.getHours());
            ps.setDate(6, Date.valueOf(t.getDateLogged()));
            ps.setString(7, t.getNotes());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) t.setId(rs.getInt(1));
            }
        }
    }

    public List<TimeLog> getTimeLogsByUser(int userId) throws SQLException {
        List<TimeLog> list = new ArrayList<>();
        String sql = "SELECT id, user_id, task, start_time, end_time, hours, date_logged, notes FROM time_logs WHERE user_id = ? ORDER BY date_logged DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TimeLog t = new TimeLog();
                    t.setId(rs.getInt("id"));
                    t.setUserId(rs.getInt("user_id"));
                    t.setTask(rs.getString("task"));
                    t.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
                    t.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
                    t.setHours(rs.getDouble("hours"));
                    t.setDateLogged(rs.getDate("date_logged").toLocalDate());
                    t.setNotes(rs.getString("notes"));
                    list.add(t);
                }
            }
        }
        return list;
    }

    public List<TimeLog> getAllTimeLogs() throws SQLException {
        List<TimeLog> list = new ArrayList<>();
        String sql = "SELECT id, user_id, task, start_time, end_time, hours, date_logged, notes FROM time_logs ORDER BY date_logged DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TimeLog t = new TimeLog();
                t.setId(rs.getInt("id"));
                t.setUserId(rs.getInt("user_id"));
                t.setTask(rs.getString("task"));
                t.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
                t.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
                t.setHours(rs.getDouble("hours"));
                t.setDateLogged(rs.getDate("date_logged").toLocalDate());
                t.setNotes(rs.getString("notes"));
                list.add(t);
            }
        }
        return list;
    }

    public void deleteTimeLog(int id) throws SQLException {
        String sql = "DELETE FROM time_logs WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}


