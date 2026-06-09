# 🛒 Best Before Date Tracker RESTfull API For BiM (A First Hard Discount Model Chain MArket)

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue.svg)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue.svg)
![JWT](https://img.shields.io/badge/Security-JWT-yellow.svg)

## 📌 Overview
This enterprise-grade RESTful API is designed to solve a critical problem in the fast-paced hard-discount retail industry: **Best Before Date (BBD) tracking and waste management.** By digitizing the manual expiration tracking processes, this system ensures stores can effectively monitor inventory, manage product lifecycles, and significantly reduce food waste and financial losses.

## 🚀 Key Features & Business Logic
The system is built on a structured **N-Layered Architecture**, ensuring a clean separation of concerns among the presentation, business logic, and data access layers. This architecture is fortified with a robust role-based access control (RBAC) mechanism.

* **Advanced Role Management:** Segregated operations for `Admin`, `BbdTracker`, and standard `User` entities to ensure security and accountability at the store level.
* **Store & Personnel Operations:** Seamless management of retail locations and task distribution among coworkers.
* **Expiration Tracking Engine (`BbdRecord`):** Core module to register, update, and monitor product expiration dates across different temperature zones and storage conditions.
* **Audit & Activity Logging (`ProductLog`, `UserActivity`):** Immutable logs for every stock movement and user action to maintain a transparent operational history.
* **Secure Authentication:** Stateless security architecture implemented via JWT (JSON Web Tokens).

## 🏗️ Architecture & Technical Decisions
* **Clean Code & SOLID:** The codebase strictly adheres to object-oriented design principles, utilizing specific DTOs (Data Transfer Objects) to decouple the database layer from the presentation layer.
* **Exception Handling:** Centralized `@ControllerAdvice` for standardized REST responses and predictable error management.
* **Database Management:** PostgreSQL is utilized as the primary relational database, initialized seamlessly via native SQL scripts.

## 🛠️ How to Run (One-Click Installation)
This project is fully containerized for zero-configuration deployments. You do not need to install Java or PostgreSQL locally.

### Prerequisites
* Docker
* Docker Compose

### Startup Instructions
1. Clone the repository to your local machine.
2. Navigate to the project root directory.
3. Execute the following command to spin up the application and the database simultaneously:

```bash
docker compose up -d --build
```

## 📚 API Documentation

Once the containers are running, you can explore the endpoints, required parameters, and HTTP response codes via the interactive Swagger UI:

* **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* **OpenAPI Specs:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs) 

## 💻 Frontend Client

This RESTful API is fully integrated with a dedicated Single Page Application (SPA) built with **Angular**. You can explore the user interface, component structure, and client-side implementation here:

👉 **[BBD Angular Client Repository](https://github.com/alibozlak/bbd-angular)**

