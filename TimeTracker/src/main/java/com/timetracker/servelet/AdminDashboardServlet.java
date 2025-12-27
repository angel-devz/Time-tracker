// THIS CODE IS WRITTEN BY ANGEL

package com.timetracker.web;

import com.timetracker.service.TimeLogService;
import com.timetracker.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {
    private UserService userService = new UserService();
    private TimeLogService timeLogService = new TimeLogService();

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login"); return;
        }
        try {
            req.setAttribute("users", userService.listAll());
            req.setAttribute("logs", timeLogService.getAllLogs());
            req.getRequestDispatcher("/WEB-INF/views/dashboard_admin.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}


