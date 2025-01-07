-- Create users table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,password_entriespassword_entryPRIMARYPRIMARYpassword_entriesPRIMARYidloginnotes
    password_hash VARCHAR(255) NOT NULL,
    temperature_unit ENUM('C', 'F') DEFAULT 'C',
    notification_preference ENUM('email', 'sms', 'app') DEFAULT 'email',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create sensors table
CREATE TABLE sensors (
    sensor_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    location VARCHAR(255) NOT NULL,
    sensor_type ENUM('indoor', 'outdoor') NOT NULL,
    status ENUM('active', 'inactive') DEFAULT 'active',
    last_updated TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Create sensor_data table
CREATE TABLE sensor_data (
    data_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sensor_id INT,
    temperature DECIMAL(5, 2),
    humidity DECIMAL(5, 2),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sensor_id) REFERENCES sensors(sensor_id) ON DELETE CASCADE
);

-- Create user_settings table
CREATE TABLE user_settings (
    setting_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    min_temperature DECIMAL(5, 2),
    max_temperature DECIMAL(5, 2),
    min_humidity DECIMAL(5, 2),
    max_humidity DECIMAL(5, 2),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Create notifications table
CREATE TABLE notifications (
    notification_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    sensor_id INT,
    notification_type ENUM('temperature', 'humidity'),
    value DECIMAL(5, 2),
    threshold DECIMAL(5, 2),
    status ENUM('sent', 'failed') DEFAULT 'sent',
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (sensor_id) REFERENCES sensors(sensor_id) ON DELETE CASCADE
);

-- Create analytics_requests table
CREATE TABLE analytics_requests (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    request_type ENUM('temperature_summary', 'humidity_summary', 'combined_summary'),
    status ENUM('pending', 'completed', 'failed') DEFAULT 'pending',
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Create data_exports table
CREATE TABLE data_exports (
    export_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    export_type ENUM('temperature', 'humidity', 'all_data'),
    file_path VARCHAR(255),
    status ENUM('pending', 'completed', 'failed') DEFAULT 'pending',
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Create system_logs table
CREATE TABLE system_logs (
    log_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    log_type ENUM('error', 'info', 'warning') NOT NULL,
    message TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);