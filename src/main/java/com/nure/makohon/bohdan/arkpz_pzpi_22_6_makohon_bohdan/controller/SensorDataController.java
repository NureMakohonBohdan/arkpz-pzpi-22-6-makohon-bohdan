//package com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.controller;
//import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.dto.SensorDataDTO;
//import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.entity.SensorData;
//import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.service.SensorDataService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/sensor-data")
//public class SensorDataController {
//
//    @Autowired
//    private SensorDataService sensorDataService;
//
//    // GET: Retrieve all sensor data
//    @GetMapping
//    public List<SensorData> getAllSensorData() {
//        return sensorDataService.findAllSensorData();
//    }
//
//    // GET: Retrieve sensor data by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<SensorData> getSensorDataById(@PathVariable Long id) {
//        return sensorDataService.findSensorDataById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // GET: Retrieve sensor data by Sensor ID
//    @GetMapping("/sensor/{sensorId}")
//    public List<SensorData> getSensorDataBySensorId(@PathVariable Integer sensorId) {
//        return sensorDataService.findSensorDataBySensorId(sensorId);
//    }
//
//    // POST: Create a new sensor data entry
//    @PostMapping
//    public ResponseEntity<SensorData> createSensorData(@RequestBody SensorData sensorData) {
//        SensorData savedSensorData = sensorDataService.saveSensorData(sensorData);
//        return ResponseEntity.ok(savedSensorData);
//    }
//
//    // PUT: Update an existing sensor data entry
//    @PutMapping("/{id}")
//    public ResponseEntity<SensorData> updateSensorData(@PathVariable Long id, @RequestBody SensorData sensorDataDetails) {
//        return sensorDataService.findSensorDataById(id).map(sensorData -> {
//            sensorData.setTemperature(sensorDataDetails.getTemperature());
//            sensorData.setHumidity(sensorDataDetails.getHumidity());
//            sensorData.setTimestamp(sensorDataDetails.getTimestamp());
//            SensorData updatedSensorData = sensorDataService.saveSensorData(sensorData);
//            return ResponseEntity.ok(updatedSensorData);
//        }).orElse(ResponseEntity.notFound().build());
//    }
//
//    // DELETE: Remove a sensor data entry by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSensorData(@PathVariable Long id) {
//        if (sensorDataService.findSensorDataById(id).isPresent()) {
//            sensorDataService.deleteSensorDataById(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    // POST: Add sensor data for a specific sensor
//    @PostMapping("/sensor/{sensorId}")
//    public ResponseEntity<SensorData> createSensorData(
//            @PathVariable Integer sensorId,
//            @Valid @RequestBody SensorDataDTO sensorDataDTO) {
//        SensorData savedSensorData = sensorDataService.createSensorData(sensorId, sensorDataDTO);
//        return ResponseEntity.ok(savedSensorData);
//    }
//}
//
