# JPA Data Model Implementation

This is a Spring Boot application that demonstrates the implementation of a data model using Java Persistence API (JPA) with Hibernate as the ORM provider.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/jpaproject/
│   │       ├── JpaProjectApplication.java
│   │       ├── entities/
│   │       │   ├── User.java
│   │       │   ├── Order.java
│   │       │   ├── OrderItem.java
│   │       │   ├── Product.java
│   │       │   ├── Category.java
│   │       │   └── OrderStatus.java
│   │       ├── repository/
│   │       │   └── UserRepository.java
│   │       └── controller/
│   │           └── UserController.java
│   └── resources/
│       └── application.properties
└── pom.xml
```

## Data Model

The application implements the following entities with JPA annotations:

### User
- **@Entity** annotation for JPA entity mapping
- **@Id** with **@GeneratedValue** for auto-generated primary key
- **@Column** annotations for database column mapping
- **@OneToMany** relationship with Order entity
- Complete constructors, getters, and setters

### Order
- **@Entity** annotation
- **@Id** with **@GeneratedValue** for auto-generated ID
- **@ManyToOne** relationship with User
- **@OneToMany** relationship with OrderItem
- **@Enumerated** for OrderStatus enum
- Proper constructors, getters, and setters

### Product
- **@Entity** annotation
- **@Id** with **@GeneratedValue**
- **@ManyToOne** relationship with Category
- **@OneToMany** relationship with OrderItem
- All required JPA annotations and methods

### Category
- **@Entity** annotation
- **@Id** with **@GeneratedValue**
- **@OneToMany** relationship with Product
- Complete JPA implementation

### OrderItem
- **@Entity** annotation (junction table for Order-Product relationship)
- **@ManyToOne** relationships with both Order and Product
- Business logic for calculating total price
- Full JPA compliance

## Key JPA Features Implemented

1. **Entity Mapping**: All classes are annotated with `@Entity`
2. **Auto-generated IDs**: All primary keys use `@GeneratedValue(strategy = GenerationType.IDENTITY)`
3. **Column Annotations**: All fields have appropriate `@Column` or relationship annotations
4. **Relationships**: Proper implementation of `@OneToMany`, `@ManyToOne` relationships
5. **Constructors**: Each entity has a default constructor and parameterized constructors
6. **Getters/Setters**: Complete accessor methods for all fields
7. **Helper Methods**: Convenience methods for managing bidirectional relationships

## Technologies Used

- **Spring Boot 2.7.0**
- **Spring Data JPA**
- **Hibernate** (JPA implementation)
- **H2 Database** (in-memory database for development)
- **Maven** (dependency management)

## How to Run

### Option 1: With Maven (Recommended)
1. **Prerequisites**: Java 11 or higher, Maven
2. **Navigate to the project directory**
3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

### Option 2: Without Maven (Manual Setup)
1. **Prerequisites**: Java 11 or higher
2. **Download Spring Boot dependencies manually** or use an IDE like IntelliJ IDEA
3. **Import the project in IntelliJ IDEA**:
   - Open IntelliJ IDEA
   - File → Open → Select the project folder
   - IntelliJ will automatically download dependencies
   - Run the `JpaProjectApplication.java` main method

### Option 3: Using IDE
1. **Open the project in IntelliJ IDEA or Eclipse**
2. **The IDE will handle dependency management**
3. **Run the main class**: `JpaProjectApplication.java`

4. **Access the application**:
   - REST API: `http://localhost:8080/api/users`
   - H2 Console: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:testdb`
     - Username: `sa`
     - Password: `password`

## API Endpoints

- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

## Database Configuration

The application uses H2 in-memory database with the following configuration:
- **DDL Auto**: `create-drop` (recreates schema on each startup)
- **Show SQL**: Enabled for development
- **H2 Console**: Enabled for database inspection

This setup is perfect for development and testing. For production, you would typically configure a persistent database like PostgreSQL or MySQL.