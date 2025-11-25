# Time-tracker
The Time Tracker is a Java-based web application that helps users record work tasks, track time logs, monitor productivity, and manage daily time usage. The system supports user authentication, admin dashboard access, and CRUD operations for time logs. It is built using:

Java (Servlets + JSP)

MySQL Database

Maven Build Tool

Apache Tomcat Server

This project follows an industry-style layered architecture using DAO, Model, and Servlet components.

🎯 Features
👤 User Features

Login & Logout

Add new time logs

View time logs

Track total hours worked daily

Add optional notes

🛠 Admin Features

View all users

Monitor all time logs

Manage database records

🧱 System Features

DAO pattern for database interactions

MVC-like project structure

Secure authentication

🗂 Project Directory Structure
TimeTracker/
├── pom.xml
├── README.md
├── .gitignore
├── database
│   └── schema.sql
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── timetracker
│       │           ├── dao
│       │           │   ├── DBConnection.java
│       │           │   ├── SystemConfigDAO.java
│       │           │   ├── TimeLogDAO.java
│       │           │   └── UserDAO.java
│       │           ├── model
│       │           │   ├── SystemConfig.java
│       │           │   ├── TimeLog.java
│       │           │   └── User.java
│       │           ├── service
│       │           │   ├── SystemConfigService.java
│       │           │   ├── TimeLogService.java
│       │           │   └── UserService.java
│       │           ├── servlet
│       │           │   ├── AdminDashboardServlet.java
│       │           │   ├── LoginServlet.java
│       │           │   ├── LogoutServlet.java
│       │           │   ├── SystemConfigServlet.java
│       │           │   ├── TimeLogServlet.java
│       │           │   └── UserManagementServlet.java
│       │           └── util
│       │               ├── PasswordUtil.java
│       │               └── Validator.java
│       ├── resources
│       └── webapp
│           ├── index.jsp
│           ├── login.jsp
│           ├── WEB-INF
│           │   ├── views
│           │   │   ├── admin-dashboard.jsp
│           │   │   ├── system-config.jsp
│           │   │   ├── time-logs.jsp
│           │   │   ├── user-dashboard.jsp
│           │   │   └── user-management.jsp
│           │   └── web.xml

💽 Database Setup

Open MySQL and create the database:

CREATE DATABASE timetracker;


Use the database:

USE timetracker;


Run the schemas:

-- Users Table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    fullname VARCHAR(100)
);

-- Time Logs Table
CREATE TABLE time_logs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    task VARCHAR(200),
    start_time DATETIME,
    end_time DATETIME,
    hours DOUBLE,
    date_logged DATE,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

⚙️ Technologies Used
Category	Tools
Language	Java
Framework	Servlets + JSP
Build Tool	Maven
Server	Apache Tomcat
Database	MySQL
Architecture	DAO + MVC-style

🔌 Configuration
1️⃣ Update Database Credentials

In DBConnection.java, change:

private static final String URL = "jdbc:mysql://localhost:3306/timetracker";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";

🔌 Configuration
1️⃣ Update Database Credentials

In DBConnection.java, change:

private static final String URL = "jdbc:mysql://localhost:3306/timetracker";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";

▶️ How to Run the Project
Step 1 – Install Required Software

Java JDK

Maven

MySQL Server

Apache Tomcat

Step 2 – Import Project

Open VS Code or IntelliJ

Open the folder TimeTracker/

Step 3 – Build Project
mvn clean install

Step 4 – Deploy on Tomcat

Place the WAR file in tomcat/webapps

Start Tomcat server

Open browser and go to:

http://localhost:8080/TimeTracker/

🧪 Testing

Login using seeded users

Add tasks

View dashboard

Check database logs for entry verification

🛡 Security Notes

Passwords should ideally be hashed before storage

HTTPS recommended for production

Basic validation implemented for input fields

📈 Future Enhancements

Email reminders

Trend analytics reports

Export logs as PDF

Edit/Delete log entries from UI

Improved UI with modern front-end framework
