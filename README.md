# 🚀 DevLaunch Backend - User Management REST API

A Spring Boot REST API project that provides User Management with Authentication, JWT Token Generation, Password Encryption, and Swagger API Documentation.

---

## 📌 Features

- User Registration
- User Login
- JWT Token Generation
- BCrypt Password Encryption
- Create User
- Get All Users
- Get User By ID
- Get User By Email
- Get User By Name
- Update User
- Delete User
- Global Exception Handling
- Request Validation
- Swagger API Documentation

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT
- Maven
- Swagger OpenAPI
- Git & GitHub

---

## 📂 Project Structure

src
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── exception
└── config

---

## 📡 API Endpoints

### Authentication

| Method | Endpoint |
|---------|----------|
| POST | /api/auth/register |
| POST | /api/auth/login |

### Users

| Method | Endpoint |
|---------|----------|
| POST | /api/users |
| GET | /api/users |
| GET | /api/users/{id} |
| GET | /api/users/email/{email} |
| GET | /api/users/name/{name} |
| PUT | /api/users/{id} |
| DELETE | /api/users/{id} |

---

## 🔐 Security

- BCrypt Password Encryption
- JWT Authentication
- Spring Security

---

## 📖 Swagger Documentation
http://localhost:8080/swagger-ui/index.html

---

## ⚙️ Database

MySQL Database

Database Name:devlaunch_db

---

## ▶️ How to Run

1. Clone the repository
git clone https://github.com/dhanshreeyellurkar-coder/devlaunch-backend.git

2. Open the project in Eclipse or IntelliJ IDEA.

3. Configure MySQL in `application.properties`.

4. Run the Spring Boot application.

5. Open Swagger:
http://localhost:8080/swagger-ui/index.html

---

## 👩‍💻 Author

**Dhanashree Yellurkar**

GitHub:
https://github.com/dhanshreeyellurkar-coder

