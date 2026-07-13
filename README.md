# 🍽️ FoodBridge

**FoodBridge** is a Spring Boot-based web application that helps reduce food wastage by connecting food donors with NGOs and volunteers. The platform enables restaurants, bakeries, event organizers, and individuals to donate surplus food, while NGOs can claim donations and volunteers assist in delivery.

---

## 📌 Problem Statement

Large quantities of edible food are wasted every day while many people struggle with food insecurity. FoodBridge provides a centralized platform where surplus food can be donated, claimed, and delivered efficiently.

---

## ✨ Features

### 👤 User Authentication
- User Registration
- User Login
- Password Encryption using BCrypt
- JWT Token Generation

### 🍱 Donation Management
- Create Donation
- View All Donations
- View Available Donations
- View Donation by ID
- Update Donation
- Delete Donation

### 🤝 Claim Management
- NGOs can claim available donations
- View all claims
- View claim details

### 🚚 Volunteer Management
- Assign volunteer to a claim
- Mark food as Picked Up
- Mark food as Delivered

### 👨‍💼 Admin Module
- View all users
- View all donations
- Delete users

### ⚙️ Additional Features
- RESTful APIs
- Global Exception Handling
- Request Validation
- Swagger API Documentation
- MySQL Database Integration

---

# 🛠️ Tech Stack

## Backend
- Java 21+
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT Authentication
- Hibernate

## Database
- MySQL

## Build Tool
- Maven

## API Testing
- Thunder Client

## Frontend
- Bootstrap 5
- HTML
- CSS
- JavaScript

---

# 📂 Project Structure

```
FoodBridge
│
├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
├── security
├── service
│   └── impl
├── static
├── templates
└── FoodbridgeApplication.java
```

---

# 📊 Database Tables

- User
- Donation
- Claim

---

# 🔄 Workflow

```
Donor
   │
   ▼
Create Donation
   │
   ▼
Donation Available
   │
   ▼
NGO Claims Donation
   │
   ▼
Volunteer Assigned
   │
   ▼
Food Picked Up
   │
   ▼
Food Delivered
```

---

# 🔌 REST APIs

## Authentication

| Method | Endpoint |
|---------|----------|
| POST | /api/auth/register |
| POST | /api/auth/login |

---

## Donation

| Method | Endpoint |
|---------|----------|
| POST | /api/donations |
| GET | /api/donations |
| GET | /api/donations/{id} |
| GET | /api/donations/available |
| PUT | /api/donations/{id} |
| DELETE | /api/donations/{id} |

---

## Claims

| Method | Endpoint |
|---------|----------|
| POST | /api/claims/{donationId} |
| GET | /api/claims |
| GET | /api/claims/{id} |
| PUT | /api/claims/{claimId}/assign/{volunteerId} |
| PUT | /api/claims/{claimId}/pickup |
| PUT | /api/claims/{claimId}/deliver |

---

## Admin

| Method | Endpoint |
|---------|----------|
| GET | /api/admin/users |
| GET | /api/admin/donations |
| DELETE | /api/admin/users/{id} |

---

# 🚀 Getting Started

## Clone the Repository

```bash
git clone https://github.com/yourusername/FoodBridge.git
```

## Navigate to the Project

```bash
cd FoodBridge
```

## Configure MySQL

Update the database configuration in:

```
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foodbridge_db
spring.datasource.username=root
spring.datasource.password=your_password
```

## Run the Application

```bash
mvn spring-boot:run
```

---

# 📖 API Documentation

After starting the application:

```
http://localhost:8080/swagger-ui/index.html
```

---

# 📸 Screenshots

- Login Page
- Register Page
- Dashboard
- Donation Management
- Claims
- Swagger UI

*(Add screenshots after completing the frontend.)*

---

# 🌱 Future Enhancements

- Email Notifications
- Google Maps Integration
- Live Location Tracking
- Food Expiry Alerts
- Image Upload for Donations
- Dashboard Analytics

---

# 👩‍💻 Author

**Kaviya Srinivasan**

GitHub: https://github.com/itsKaviya

---

## ⭐ If you found this project useful, consider giving it a star!