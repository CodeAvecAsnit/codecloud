# Spring Student CRUD Application

A classic Student Management System built with **Spring Framework** (not Spring Boot), Spring JDBC, JSP, and traditional Tomcat servlet container. This application demonstrates traditional Java web development with dependency injection and clean architecture using XML-based Spring configuration.

## Features

- **Create**: Add new student records
- **Read**: View all students or search for individual students
- **Update**: Modify existing student information
- **Delete**: Remove student records from the database
- **Responsive UI**: Beautiful, modern and user-friendly interface using HTML5 and CSS3
- **Traditional Spring Architecture**: XML-based configuration with DispatcherServlet

## Technology Stack

- **Framework**: Spring Framework 6.1.0 (Traditional Spring, not Boot)
- **Database**: MySQL
- **ORM/Data Access**: Spring JDBC with JdbcTemplate
- **View**: JSP (Java Server Pages) with JSTL
- **Web Container**: Apache Tomcat (external, not embedded)
- **Build Tool**: Maven
- **Java Version**: Java 17+
- **Configuration**: XML-based Spring configuration
- **Logging**: SLF4J + Logback
- **Dependency Injection**: Constructor Injection via Lombok

## Project Structure

```
spring-student-crud/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/student/app/
│   │   │       ├── StudentCrudApplication.java (Application reference)
│   │   │       ├── controller/
│   │   │       │   ├── HomeController.java
│   │   │       │   └── StudentController.java
│   │   │       ├── service/
│   │   │       │   ├── StudentService.java (Interface)
│   │   │       │   └── StudentServiceImpl.java (Implementation)
│   │   │       ├── dao/
│   │   │       │   ├── StudentDao.java (Interface)
│   │   │       │   └── StudentDaoImpl.java (Implementation)
│   │   │       └── model/
│   │   │           └── Student.java
│   │   ├── resources/
│   │   │   ├── spring-config.xml (Root application context)
│   │   │   ├── dispatcher-servlet.xml (DispatcherServlet configuration)
│   │   │   ├── database.properties (Database configuration)
│   │   │   ├── logback.xml (Logging configuration)
│   │   │   └── schema.sql (Database setup)
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           ├── web.xml (Deployment descriptor)
│   │           └── views/
│   │               ├── index.jsp
│   │               ├── list-students.jsp
│   │               ├── add-student.jsp
│   │               ├── edit-student.jsp
│   │               ├── view-student.jsp
│   │               ├── error-404.jsp
│   │               └── error-500.jsp
│   └── test/
│       └── java/
├── pom.xml (Maven Configuration - WAR packaging)
├── README.md
├── QUICKSTART.md
└── .gitignore
```

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Apache Tomcat 10+ (or any Jakarta EE compatible container)
- MySQL Server 5.7+

## Installation & Setup

### 1. Download/Clone the Project

```bash
cd /Users/asnitbakhati/Desktop/newFolder/spring-webapp
```

### 2. Set Up the Database

First, ensure MySQL is running. Then execute the SQL script:

```bash
mysql -u root -p < src/main/resources/schema.sql
```

Or manually execute the commands in `schema.sql`:

```sql
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    gpa DECIMAL(3, 2) NOT NULL,
    department VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE USER IF NOT EXISTS 'student_user'@'localhost' IDENTIFIED BY 'student_pass@123';
GRANT ALL PRIVILEGES ON student_db.* TO 'student_user'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Build the Project as WAR

```bash
mvn clean install
```

This generates `target/spring-student-crud.war`

### 4. Deploy the WAR File

#### Option 1: Using Tomcat Maven Plugin (Quick Development)

```bash
mvn tomcat7:deploy
```

Or run directly:

```bash
mvn tomcat7:run
```

#### Option 2: Manual Deployment to Tomcat

1. Download and install Apache Tomcat
2. Copy the WAR file to Tomcat's `webapps` directory:
   ```bash
   cp target/spring-student-crud.war $TOMCAT_HOME/webapps/
   ```
3. Start Tomcat:
   ```bash
   $TOMCAT_HOME/bin/startup.sh
   ```

The application will be available at `http://localhost:8080/spring-student-crud`

## Spring Configuration Explained

### web.xml (Deployment Descriptor)
- Defines ContextLoaderListener to load Spring application context
- Configures DispatcherServlet to handle all requests
- Points to XML configuration files

### spring-config.xml (Root Application Context)
- Component scanning for @Repository and @Service beans
- DataSource configuration (JDBC connection pool)
- JdbcTemplate bean creation
- Database property placeholder configuration

### dispatcher-servlet.xml (Web MVC Configuration)
- Component scanning for @Controller beans
- View resolver configuration (JSP location)
- MVC annotation support
- Static resource handling

## Usage

1. **Access the Application**: Open your browser and navigate to:
   - With WAR deployment: `http://localhost:8080/spring-student-crud`
   - With Tomcat plugin: `http://localhost:8080`

2. **Home Page**: The welcome page provides quick access to:
   - View All Students
   - Add New Student

3. **View Students**: Click "View All Students" to see the list of all registered students

4. **Add Student**: Click "Add New Student" and fill in the form with:
   - Name (required)
   - Email (required)
   - Phone (required)
   - GPA (required)
   - Department (required)

5. **View Student Details**: Click the "View" button in the student list

6. **Edit Student**: Click the "Edit" button to modify information

7. **Delete Student**: Click the "Delete" button to remove a student

## Architecture

### Layered Architecture

```
┌──────────────────────────────────┐
│  Servlet Container (Tomcat)      │
│  DispatcherServlet (web.xml)     │
└───────────────┬──────────────────┘
                │
┌───────────────▼──────────────────┐
│   View Layer (JSP/JSTL)          │
│   (HTML Forms & Display)         │
└───────────────┬──────────────────┘
                │
┌───────────────▼──────────────────┐
│   Controller Layer               │
│   (StudentController)            │
│   (Handles HTTP Requests)        │
└───────────────┬──────────────────┘
                │
┌───────────────▼──────────────────┐
│   Service Layer                  │
│ (StudentService/StudentServiceImpl)│
│   (Business Logic)               │
└───────────────┬──────────────────┘
                │
┌───────────────▼──────────────────┐
│   DAO Layer                      │
│ (StudentDao/StudentDaoImpl)       │
│ (JDBC Data Access)               │
└───────────────┬──────────────────┘
                │
┌───────────────▼──────────────────┐
│   Database Layer                 │
│      (MySQL Database)            │
└──────────────────────────────────┘
```

## Dependency Injection

The application uses Spring's **Constructor Injection** via `@RequiredArgsConstructor` (Lombok):

- `JdbcTemplate` is injected into `StudentDaoImpl`
- `StudentDao` is injected into `StudentServiceImpl`
- `StudentService` is injected into `StudentController`

All components are auto-discovered via `<context:component-scan>` in XML configuration files.

## Configuration

Database credentials can be modified in `src/main/resources/database.properties`:

```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/student_db
db.username=student_user
db.password=student_pass@123
```

Modify Tomcat port in `pom.xml`:

```xml
<configuration>
    <port>8080</port>
    <path>/</path>
</configuration>
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Home page |
| GET | `/students` | View all students |
| GET | `/students/new` | Show add student form |
| POST | `/students/add` | Create a new student |
| GET | `/students/{id}` | View student details |
| GET | `/students/edit/{id}` | Show edit student form |
| POST | `/students/update` | Update student |
| GET | `/students/delete/{id}` | Delete student |

## Error Handling

- 404 errors redirect to `error-404.jsp`
- 500 errors redirect to `error-500.jsp`
- Database connectivity errors are logged
- Validation is performed in the Service layer

## Traditional Spring vs Spring Boot

| Feature | Traditional Spring | Spring Boot |
|---------|-------------------|-----------|
| Configuration | XML-based | Properties/YAML-based |
| Packaging | WAR file | Executable JAR |
| Server | External Tomcat | Embedded Tomcat |
| Configuration Files | spring-config.xml, web.xml | application.properties |
| Dependency Management | Manual version control | Parent POM |
| Startup | Servlet Container starts | Main method runs |

## Troubleshooting

### MySQL Connection Error
- Ensure MySQL is running
- Verify database credentials in `database.properties`
- Check if the `student_db` database exists

### JSP Not Found
- Ensure JSP files are in `/WEB-INF/views/`
- Check view prefix in `dispatcher-servlet.xml`: `prefix="/WEB-INF/views/"`
- Verify `suffix=".jsp"`

### WAR Deployment Issues
- Ensure Tomcat is properly installed
- Check Tomcat logs in `$TOMCAT_HOME/logs/`
- Verify web.xml syntax

### Port Already in Use
- Change the port in `pom.xml` tomcat7-maven-plugin configuration
- Or use a different Tomcat instance

## Files Summary

| File | Purpose |
|------|---------|
| `web.xml` | Deployment descriptor, servlet configuration |
| `spring-config.xml` | Root application context (beans, services, DAOs) |
| `dispatcher-servlet.xml` | Web MVC configuration |
| `database.properties` | Database connection details |
| `logback.xml` | Logging configuration |
| Controllers | Handle HTTP requests |
| Services | Business logic |
| DAOs | Data access via Spring JDBC |
| JSP Views | Web UI pages |

## Future Enhancements

- Add authentication and authorization
- Implement pagination for the student list
- Add search and filter functionality
- Add data validation and error messages
- REST API endpoints
- Unit and integration testing
- Service layer transaction management
- Connection pooling with DBCP or HikariCP

## License

This project is open source and available under the MIT License.


---


