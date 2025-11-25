# Time Tracker – Java Web Application

## 📌 Overview

The **Time Tracker** is a Java web application that helps users record tasks, track time logs, view productivity reports, and manage work hours. It includes user login, time logging, admin monitoring, and secure database storage. The system is built using Java Servlets and JSP with a MySQL database and Maven build process.

---

## 🎯 Features

### 👤 User Features

* Login and Logout
* Add new time logs
* View daily time logs
* Record start & end time
* Store task notes

### 🛠 Admin Features

* View all users
* Monitor all time logs
* Manage system database

### 🧱 System Features

* DAO pattern for database logic
* Modular MVC-like structure
* Session-based authentication
* Fully working CRUD operations

---

## 🗂 Project Directory Structure

```
TimeTracker/
 ├── src/
 │    └── main/
 │         ├── java/
 │         │    └── com/timetracker/
 │         │         ├── model/
 │         │         ├── dao/
 │         │         └── servlet/
 │         └── webapp/
 │              ├── index.jsp
 │              ├── login.jsp
 │              ├── dashboard.jsp
 │              └── WEB-INF/
 │                   └── web.xml
 ├── database/
 │    ├── schema.sql
 │    └── connection.sql
 └── pom.xml
```

---

## 💽 Database Setup

Run the following commands in MySQL:

```sql
CREATE DATABASE timetracker;
USE timetracker;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    fullname VARCHAR(100)
);

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
```

---

## ⚙️ Technologies Used

| Category     | Tools           |
| ------------ | --------------- |
| Language     | Java            |
| Framework    | Servlets + JSP  |
| Build Tool   | Maven           |
| Server       | Apache Tomcat   |
| Database     | MySQL           |
| Architecture | DAO + MVC-style |

---

## 🔌 Database Configuration

Open the file:

`src/main/java/com/timetracker/dao/DBConnection.java`

and update:

```java
private static final String URL = "jdbc:mysql://localhost:3306/timetracker";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";
```

---

## ▶️ How to Run the Project

### 1️⃣ Install Required Software

* Java JDK
* Maven
* MySQL Server
* Apache Tomcat
* VS Code or IntelliJ IDEA

### 2️⃣ Import the Project

* Open the folder `TimeTracker/` in your IDE

### 3️⃣ Build

```bash
mvn clean install
```

### 4️⃣ Deploy

* Copy the generated WAR file into `tomcat/webapps`
* Start Apache Tomcat
* Open browser:

```
http://localhost:8080/TimeTracker/
```

---

## 🧪 Testing Instructions

* Login with test credentials
* Add time logs
* View dashboard
* Check database tables for stored logs

---

## 🛡 Security Notes

* Use hashed passwords for production
* HTTPS recommended
* Basic input validation included

---

## 📈 Future Enhancements

* Edit/Delete time logs
* Email reminders
* Analytics dashboards
* Export reports
* UI modernization (React/Bootstrap/etc.)
