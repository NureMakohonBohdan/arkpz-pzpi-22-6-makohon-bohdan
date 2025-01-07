пзпі-22-6

Макогон Богдан Олександрович

Програмна система для моніторінгу опалення будинку

# IoT Temperature and Humidity Monitoring System

### Overview
The **IoT Temperature and Humidity Monitoring System** is a Spring Boot application that provides RESTful APIs to manage temperature and humidity data collected from IoT sensors. It includes features like user management, sensor data tracking, threshold-based notifications, analytics requests, and data exports.

---


## Table of Contents
1. [Project Setup](#project-setup)
2. [Technologies Used](#technologies-used)
3. [API Endpoints](#api-endpoints)
    - [User](#user-apis)
    - [Sensor](#sensor-apis)
    - [Sensor Data](#sensor-data-apis)
    - [User Setting](#user-setting-apis)
    - [Notification](#notification-apis)
    - [Analytics Request](#analytics-request-apis)
    - [Data Export](#data-export-apis)
    - [System Logs](#system-log-apis)
4. [Database Schema](#database-schema)
5. [Running the Application](#running-the-application)

---

## Project Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-repo/iot-system.git
   cd iot-system
   ```

2. **Set Up MySQL Database**  
   Create a database named `iot_system`.

3. **Configure `application.properties`**
   Update database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/iot_system
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

4. **Build and Run**
   ```bash
   mvn spring-boot:run
   ```

---

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL Database**
- **Lombok**
- **Spring Boot DevTools**
- **Postman (for testing APIs)**

---

## API Endpoints

# API Endpoints for IoT System

## UserController

| Method | Endpoint           | Description                  |
|------------|------------------------|----------------------------------|
| GET      | /api/users           | Retrieve all users               |
| GET      | /api/users/{id}      | Retrieve a user by ID            |
| POST     | /api/users           | Create a new user                |
| PUT      | /api/users/{id}      | Update an existing user          |
| DELETE   | /api/users/{id}      | Delete a user by ID              |

---

## SensorController

| Method | Endpoint                 | Description                  |
|------------|------------------------------|----------------------------------|
| GET      | /api/sensors               | Retrieve all sensors             |
| GET      | /api/sensors/{id}          | Retrieve a sensor by ID          |
| POST     | /api/sensors/user/{userId} | Create a new sensor for a user   |
| PUT      | /api/sensors/{id}          | Update an existing sensor        |
| DELETE   | /api/sensors/{id}          | Delete a sensor by ID            |

---

## SensorDataController

| Method | Endpoint                          | Description                               |
|------------|---------------------------------------|-----------------------------------------------|
| GET      | /api/sensor-data                   | Retrieve all sensor data                      |
| GET      | /api/sensor-data/{id}              | Retrieve sensor data by ID                    |
| GET      | /api/sensor-data/sensor/{sensorId} | Retrieve all sensor data for a specific sensor |
| POST     | /api/sensor-data/sensor/{sensorId} | Add sensor data for a specific sensor         |
| DELETE   | /api/sensor-data/{id}              | Delete sensor data by ID                      |

---

## UserSettingController

| Method | Endpoint                      | Description                          |
|------------|-----------------------------------|------------------------------------------|
| GET      | /api/user-settings/{id}        | Retrieve user settings by ID             |
| GET      | /api/user-settings/user/{userId}| Retrieve user settings for a specific user |
| POST     | /api/user-settings/user/{userId}| Add user settings for a specific user    |
| PUT      | /api/user-settings/{id}        | Update user settings by ID               |
| DELETE   | /api/user-settings/{id}        | Delete user settings by ID               |

---

## NotificationController

| Method | Endpoint                              | Description                                  |
|------------|-------------------------------------------|-------------------------------------------------|
| GET      | /api/notifications                     | Retrieve all notifications                      |
| GET      | /api/notifications/{id}                | Retrieve a notification by ID                   |
| GET      | /api/notifications/user/{userId}       | Retrieve all notifications for a specific user  |
| POST     | /api/notifications/user/{userId}/sensor/{sensorId} | Create a notification for a specific user and sensor |
| DELETE   | /api/notifications/{id}                | Delete a notification by ID                     |

---

## AnalyticsRequestController

| Method | Endpoint                                   | Description                                       |
|------------|-----------------------------------------------|-------------------------------------------------------|
| GET      | /api/analytics-requests                    | Retrieve all analytics requests                      |
| GET      | /api/analytics-requests/{id}               | Retrieve a specific analytics request by its ID      |
| GET      | /api/analytics-requests/user/{userId}       | Retrieve all analytics requests for a specific user  |
| POST     | /api/analytics-requests/user/{userId}       | Create a new analytics request for a specific user   |
| DELETE   | /api/analytics-requests/user/{userId}/{requestId} | Delete a specific analytics request for a user |

---
## SystemLogController

| Method | Endpoint                      | Description                        |
|------------|-----------------------------------|----------------------------------------|
| GET      | /api/system-logs               | Retrieve all system logs               |
| GET      | /api/system-logs/{id}          | Retrieve a specific log by ID          |
| GET      | /api/system-logs/type/{type}   | Retrieve all logs of a specific type   |
| POST     | /api/system-logs               | Add a new system log                   |
| DELETE   | /api/system-logs/{id}          | Delete a specific log by ID            |
---

## Database Schema

- **User**: `user_id`, `email`, `password_hash`, `notification_preference`
- **Sensor**: `sensor_id`, `location`, `sensor_type`, `status`
- **SensorData**: `data_id`, `sensor_id`, `temperature`, `humidity`
- **UserSetting**: `setting_id`, `user_id`, `min_temperature`, `max_temperature`
- **Notification**: `notification_id`, `user_id`, `sensor_id`, `value`, `threshold`
- **AnalyticsRequest**: `request_id`, `user_id`, `start_date`, `end_date`
- **DataExport**: `export_id`, `user_id`, `export_type`, `file_path`
- **SystemLog**: `log_id`, `log_type`, `message`, `timestamp`

---

## Running the Application

1. Build the project:
   ```bash
   mvn clean package
   ```

2. Run the project:
   ```bash
   mvn spring-boot:run
   ```

3. Access the API at:
   ```
   http://localhost:8080
   ```

