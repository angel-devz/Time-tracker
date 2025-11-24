package com.timetracker.service;

import com.timetracker.dao.UserDAO;
import com.timetracker.model.User;
import com.timetracker.util.PasswordUtil;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO dao = new UserDAO();

    public void register(User user) throws SQLException {
        // basic validation
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null)
            throw new IllegalArgumentException("Missing fields");

        // hash password
        user.setPassword(PasswordUtil.hash(user.getPassword()));
        dao.createUser(user);
    }

    public User login(String email, String password) throws SQLException {
        User u = dao.findByEmail(email);
        if (u == null) return null;
        if (PasswordUtil.verify(password, u.getPassword())) return u;
        return null;
    }

    public List<User> listAll() throws SQLException {
        return dao.findAll();
    }

    public void updateRole(int userId, String role) throws SQLException {
        dao.updateRole(userId, role);
    }

    public void deleteUser(int userId) throws SQLException {
        dao.deleteUser(userId);
    }
}
