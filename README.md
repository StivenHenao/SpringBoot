
# 🚀 Spring Boot Projects  

This repository contains simple yet functional Spring Boot projects to demonstrate key backend concepts such as CRUD operations and user authentication.  

## 📌 Projects  

### 1️⃣ **Basic Spring Boot CRUD Example**  
🔹 A simple CRUD application using **Spring Boot, H2 Database, and JPA**.  
🔹 Includes an **entity, repository, and controller** to manage clients.  
🔹 Provides basic **Create, Read, Update, and Delete** operations.  

📂 **Tech Stack:**  
- Java + Spring Boot  
- JPA (Hibernate)  
- H2 Database  

### 2️⃣ **Simple Spring Boot Login with Thymeleaf**  
🔹 A basic login system using **Spring Boot and Thymeleaf**.  
🔹 Implements **authentication logic** and redirects users based on success or failure.  
🔹 If login is successful, the user is redirected to a **dashboard** displaying their username.  
🔹 On failure, they are redirected to an **error page**.  

📂 **Tech Stack:**  
- Java + Spring Boot  
- Thymeleaf  
- Spring MVC

### 3️⃣ **Spring Boot Employee API (REST CRUD)**
🔹 Una API REST para la gestión de empleados usando **Spring Boot, JPA y H2 Database**.  
🔹 Implementa **operaciones CRUD** con un controlador REST y un repositorio JPA.  
🔹 Maneja respuestas HTTP adecuadas utilizando `ResponseEntity`.  
🔹 Usa **Spring Boot DevTools** para recarga automática en desarrollo.  

📂 **Tech Stack:**  
- Java + Spring Boot  
- Spring Web  
- Spring Data JPA  
- H2 Database  
- Spring Boot DevTools  

📌 **Endpoints principales:**  
- **GET** `/empleados` → Lista todos los empleados.  
- **GET** `/empleados/{id}` → Obtiene un empleado por ID.  
- **POST** `/empleados` → Crea un nuevo empleado.  
- **PUT** `/empleados/{id}` → Actualiza un empleado existente.  
- **DELETE** `/empleados/{id}` → Elimina un empleado.  


## 🚀 How to Run  
Make sure you have **Java 17+** and **Maven** installed.  

1️⃣ **Clone the repository:**  
```bash
git clone https://github.com/tu-usuario/tu-repo.git
cd tu-repo
```

2️⃣ **Run any project using Maven:**  
```bash
mvn spring-boot:run
```

3️⃣ **Open the application in your browser:**  
http://localhost:8080
