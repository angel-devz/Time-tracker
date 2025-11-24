package com.timetracker.service;

import com.timetracker.dao.TimeLogDAO;
import com.timetracker.model.TimeLog;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TimeLogService {
    private TimeLogDAO dao = new TimeLogDAO();

    public void addTimeLog(TimeLog t) throws SQLException {
        // compute hours if not set
        if (t.getStartTime() == null || t.getEndTime() == null) throw new IllegalArgumentException("Start and end time required");
        Duration d = Duration.between(t.getStartTime(), t.getEndTime());
        double hours = d.toMinutes() / 60.0;
        if (hours <= 0) throw new IllegalArgumentException("End time must be after start time");
        t.setHours(Math.round(hours * 100.0) / 100.0);
        if (t.getDateLogged() == null) t.setDateLogged(LocalDate.from(t.getStartTime()));
        dao.addTimeLog(t);
    }

    public List getLogsForUser(int userId) throws SQLException {
        return dao.getTimeLogsByUser(userId);
    }

    public List getAllLogs() throws SQLException {
        return dao.getAllTimeLogs();
    }

    public void deleteLog(int id) throws SQLException {
        dao.deleteTimeLog(id);
    }
}
