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

File:

`src/main/java/com/timetracker/dao/DBConnection.java`

Update:

```java
private static final String URL = "jdbc:mysql://localhost:3306/timetracker";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";
```

---

## ▶️ How to Run the Project

### 1️⃣ Install Software

* Java JDK
* Maven
* MySQL
* Apache Tomcat
* VS Code or IntelliJ IDEA

### 2️⃣ Import Project

* Open the folder `TimeTracker/` in your IDE

### 3️⃣ Build

```bash
mvn clean install
```

### 4️⃣ Deploy and Start

* Copy the generated WAR file to `tomcat/webapps`
* Start Tomcat
* Visit:

```
http://localhost:8080/TimeTracker/
```

---

## 🚀 How to Use (Quick Start)

1. **Open the website**

   ```
   http://localhost:8080/TimeTracker/
   ```

2. **Login**

   * Use a valid username and password from the `users` table.

3. **Add Time Logs**

   * Open the *Add Time Log* form.
   * Enter:

     * Task name
     * Start time
     * End time
     * Notes (optional)
   * Click **Submit**.

4. **View Recorded Logs**

   * Go to **View Logs**
   * All entries will display in a table with:

     * Date
     * Task
     * Hours
     * Notes

5. **Admin Access**

   * Admin can:

     * View all users
     * View all logs

6. **Verify Data in Database**

   * Open MySQL

   * Run:

     ```sql
     SELECT * FROM users;
     SELECT * FROM time_logs;
     ```

   * All stored records will appear in the database.

---

## 🧪 Testing Instructions

* Login
* Add time logs
* View dashboard
* Confirm entries stored in MySQL

---

## 🔐 Security Notes

* Use hashed passwords for production
* HTTPS recommended
* Basic validation included

---

## 📈 Future Enhancements

* Edit/Delete logs
* Weekly reports
* Export PDF/CSV
* Analytics charts
* Email reminders
* UI redesign with modern frontend
