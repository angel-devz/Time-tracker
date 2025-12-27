// this code is written by Angel
package com.timetracker.web;

import com.timetracker.model.TimeLog;
import com.timetracker.model.User;
import com.timetracker.service.TimeLogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/timelog")
public class TimeLogServlet extends HttpServlet {
    private TimeLogService service = new TimeLogService();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/add_timelog.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login"); return;
        }
        try {
            User u = (User) session.getAttribute("user");
            String task = req.getParameter("task");
            String start = req.getParameter("start_time"); // format: yyyy-MM-dd'T'HH:mm
            String end = req.getParameter("end_time");
            String notes = req.getParameter("notes");
            LocalDateTime st = LocalDateTime.parse(start, dtf);
            LocalDateTime en = LocalDateTime.parse(end, dtf);
            TimeLog t = new TimeLog(u.getId(), task, st, en, 0, LocalDate.from(st), notes);
            service.addTimeLog(t);
            resp.sendRedirect(req.getContextPath() + "/user/dashboard");
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/add_timelog.jsp").forward(req, resp);
        }
    }
}

