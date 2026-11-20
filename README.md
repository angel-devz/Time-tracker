# Time Tracker – Java Web Application

A Java web application for recording time spent on tasks. Users log in, add time logs (task, start and end time, notes) and see their logs; admins can see every user's logs. Built with **Java Servlets, JSP, MySQL and Maven**, following a DAO + service layered structure.

## Features

**Users**
- Log in and log out (session-based)
- Add time logs with task name, start/end time and notes
- Hours are calculated from start and end time

**Admin**
- View all users and all time logs from the admin dashboard

**Under the hood**
- DAO pattern for database access
- Service layer between servlets and DAOs
- Passwords stored as SHA-256 hashes

## Tech Stack

| Category     | Tools                     |
|--------------|---------------------------|
| Language     | Java 11                   |
| Web          | Servlets + JSP (JSTL)     |
| Build        | Maven                     |
| Server       | Apache Tomcat 9           |
| Database     | MySQL 8                   |

## Project Structure

```
TimeTracker/
├── pom.xml
├── database/
│   └── schema.sql                 # Creates the database, tables and an admin user
└── src/main/
    ├── java/com/timetracker/
    │   ├── model/                 # User, TimeLog
    │   ├── dao/                   # DBConnection, UserDAO, TimeLogDAO
    │   ├── service/               # UserService, TimeLogService
    │   ├── util/                  # PasswordUtil (SHA-256 hashing)
    │   └── web/                   # Login, Logout, TimeLog, AdminDashboard servlets
    └── webapp/WEB-INF/
        ├── web.xml
        └── views/                 # admin-dashboard.jsp, user-dashboard.jsp, time-logs.jsp
```

## Getting Started

### 1. Install
Java JDK 11+, Maven, MySQL 8 and Apache Tomcat 9.

### 2. Set up the database
```bash
mysql -u root -p < TimeTracker/database/schema.sql
```
This creates the `timetracker` database with the `users` and `time_logs` tables.

The script adds an admin user with the placeholder password `REPLACE_ME_WITH_HASHED_PASSWORD`. Replace it with the SHA-256 hash of the password you want, for example:
```sql
UPDATE users SET password = SHA2('admin123', 256) WHERE email = 'admin@example.com';
```

### 3. Configure the connection
Edit `TimeTracker/src/main/java/com/timetracker/dao/DBConnection.java` and set your MySQL username and password:
```java
private static final String URL = "jdbc:mysql://localhost:3306/timetracker?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
```

### 4. Build and deploy
```bash
cd TimeTracker
mvn clean package
```
Copy `target/TimeTracker.war` into Tomcat's `webapps/` folder, start Tomcat and open
`http://localhost:8080/TimeTracker/`.

Log in with your email (e.g. `admin@example.com`) and password.

## Roadmap

- [ ] Login page (`login.jsp`) and add-time-log form (`add_timelog.jsp`)
- [ ] User dashboard servlet (`/user/dashboard`)
- [ ] Edit and delete time logs
- [ ] Weekly reports and charts
- [ ] Export to PDF / CSV
- [ ] Stronger password hashing (BCrypt) and HTTPS

## Team

- Angel Lakra
- Nitu Sashmal
- Tanishka Malik
