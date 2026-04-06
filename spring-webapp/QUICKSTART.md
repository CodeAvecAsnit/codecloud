# Quick Start Guide - Traditional Spring Application

##  Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 5.7+
- Apache Tomcat 10+ (or any Jakarta EE compatible servlet container)

### Step 1: Setup Database

```bash
# Login to MySQL
mysql -u root -p

# Execute the SQL commands from src/main/resources/schema.sql
```

Or copy-paste directly:
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

### Step 2: Build as WAR File

```bash
# Navigate to project directory
cd spring-webapp

# Build the WAR file
mvn clean install
```

This generates `target/spring-student-crud.war`

### Step 3: Deploy & Run

####  Quick Option - Use Tomcat Maven Plugin (Development)

```bash
# Run directly with Tomcat plugin (no deployment needed)
mvn tomcat7:run
```

Access at: `http://localhost:8080/`

#### 📦 Standard Option - Deploy to External Tomcat

1. Download Apache Tomcat 10+ from https://tomcat.apache.org/
2. Extract to a directory (e.g., `/opt/tomcat` or `C:\tomcat`)
3. Copy WAR file:
   ```bash
   cp target/spring-student-crud.war $TOMCAT_HOME/webapps/
   ```
4. Start Tomcat:
   ```bash
   # On Mac/Linux
   $TOMCAT_HOME/bin/startup.sh
   
   # On Windows
   %TOMCAT_HOME%\bin\startup.bat
   ```

Access at: `http://localhost:8080/spring-student-crud`

##  Features

- Traditional Spring Framework (XML-based config)
- Spring MVC
- Spring JDBC with JdbcTemplate
- JSP with JSTL
- Create Students
- View All Students 
- View Student Details
- Edit Student Information
- Delete Students
- Responsive UI
- Constructor Injection (Dependency Injection)

## Architecture

- **web.xml**: Servlet configuration & Spring listener
- **spring-config.xml**: Application context (beans, services, DAOs)
- **dispatcher-servlet.xml**: Web MVC configuration
- **Controllers**: Handle HTTP requests
- **Services**: Business logic layer
- **DAOs**: JDBC data access
- **Models**: Entity classes
- **JSP Views**: HTML presentation

## Configuration Files

```
src/main/resources/
├── spring-config.xml        # Root Spring context
├── dispatcher-servlet.xml   # Web MVC config
├── database.properties      # Database connection
├── logback.xml             # Logging config
└── schema.sql              # Database setup
```

##  Main Routes

- `/` - Home Page
- `/students` - List All Students
- `/students/new` - Add New Student
- `/students/{id}` - View Student Details
- `/students/edit/{id}` - Edit Student
- `/students/delete/{id}` - Delete Student

## Technologies

- **Spring Framework 6.1.0** 
- **Spring JDBC** - JdbcTemplate
- **Spring MVC** - Web controller support
- **JSP/JSTL** - View layer
- **MySQL** - Database
- **Maven** - Build tool
- **Apache Tomcat** - Servlet container
- **Lombok** - Boilerplate reduction
- **SLF4J + Logback** - Logging
- **Java 17+**

## ️ Configuration

### Database Connection
Edit `src/main/resources/database.properties`:
```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/student_db
db.username=student_user
db.password=student_pass@123
```

### Change Tomcat Port
Edit `pom.xml` in tomcat7-maven-plugin:
```xml
<configuration>
    <port>9090</port>  <!-- Change this -->
    <path>/</path>
</configuration>
```

Then run:
```bash
mvn tomcat7:run
```

##  Deployment Options

| Option | Command | URL | Best For |
|--------|---------|-----|----------|
| Maven Plugin | `mvn tomcat7:run` | `localhost:8080/` | Development |
| External Deploy | Manual copy to webapps | `localhost:8080/spring-student-crud` | Staging/Production |

##  Troubleshooting

**Issue**: Cannot find MySQL database
```bash
# Ensure MySQL is running and execute schema.sql
mysql -u root -p < src/main/resources/schema.sql
```

**Issue**: Port 8080 already in use
```bash
# Change port in pom.xml or use different Tomcat instance
mvn tomcat7:run -Dmaven.tomcat.port=9090
```

**Issue**: JSP pages not found
- Check if JSP files are in `/WEB-INF/views/`
- Verify view prefix in `dispatcher-servlet.xml`
- Ensure tomcat7-maven-plugin version is correct

**Issue**: Spring beans not loading
- Check `spring-config.xml` for correct component-scan package
- Verify `web.xml` points to correct Spring config files
- Check logs for errors during context initialization

##  Key Files

| File | Purpose |
|------|---------|
| `web.xml` | Deployment descriptor, DispatcherServlet |
| `spring-config.xml` | Root app context, DataSource, beans |
| `dispatcher-servlet.xml` | MVC setup, view resolver |
| `StudentController.java` | HTTP request handling |
| `StudentService.java` | Business logic |
| `StudentDao.java` | Database access (JDBC) |
| `*.jsp` | HTML views |

##  Learn More

For detailed information, see:
- [README.md](README.md) - Full documentation
- Spring Framework Docs: https://docs.spring.io/spring-framework/
- Tomcat Documentation: https://tomcat.apache.org/


