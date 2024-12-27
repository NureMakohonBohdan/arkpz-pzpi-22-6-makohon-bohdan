package com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.controller;
import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.dto.SensorDTO;

import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.entity.Sensor;
import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    // GET: Retrieve all sensors
    @GetMapping
    public List<Sensor> getAllSensors() {
        return sensorService.findAllSensors();
    }

    // GET: Retrieve a sensor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable Integer id) {
        return sensorService.findSensorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Create a new sensor
    @PostMapping("/user/{userId}")
    public ResponseEntity<Sensor> createSensor(
            @PathVariable Integer userId,
            @Valid @RequestBody SensorDTO sensorDTO) {
        Sensor savedSensor = sensorService.createSensor(userId, sensorDTO);
        return ResponseEntity.ok(savedSensor);
    }

    // PUT: Update an existing sensor
    @PutMapping("/{id}")
    public ResponseEntity<Sensor> updateSensor(@PathVariable Integer id, @RequestBody Sensor sensorDetails) {
        return sensorService.findSensorById(id).map(sensor -> {
            sensor.setLocation(sensorDetails.getLocation());
            sensor.setSensorType(sensorDetails.getSensorType());
            sensor.setStatus(sensorDetails.getStatus());
            sensor.setLastUpdated(sensorDetails.getLastUpdated());
            Sensor updatedSensor = sensorService.saveSensor(sensor);
            return ResponseEntity.ok(updatedSensor);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Remove a sensor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Integer id) {
        if (sensorService.findSensorById(id).isPresent()) {
            sensorService.deleteSensorById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // GET: Retrieve all sensors for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Sensor>> getSensorsByUserId(@PathVariable Integer userId) {
        List<Sensor> sensors = sensorService.getSensorsByUserId(userId);
        return ResponseEntity.ok(sensors);
    }
}
