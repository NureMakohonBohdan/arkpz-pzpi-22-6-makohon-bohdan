package com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.controller;
import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.dto.UserSettingDTO;
import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.entity.UserSetting;
import com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.service.UserSettingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-settings")
public class UserSettingController {

    @Autowired
    private UserSettingService userSettingService;

    // GET: Retrieve user setting by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserSetting> getUserSettingById(@PathVariable Integer id) {
        return userSettingService.findUserSettingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET: Retrieve user setting by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserSetting> getUserSettingByUserId(@PathVariable Integer userId) {
        UserSetting userSetting = userSettingService.findUserSettingByUserId(userId);
        if (userSetting != null) {
            return ResponseEntity.ok(userSetting);
        }
        return ResponseEntity.notFound().build();
    }

    // POST: Create a new user setting
    @PostMapping
    public ResponseEntity<UserSetting> createUserSetting(@RequestBody UserSetting userSetting) {
        UserSetting savedUserSetting = userSettingService.saveUserSetting(userSetting);
        return ResponseEntity.ok(savedUserSetting);
    }

    // PUT: Update an existing user setting
    @PutMapping("/{id}")
    public ResponseEntity<UserSetting> updateUserSetting(@PathVariable Integer id, @RequestBody UserSetting userSettingDetails) {
        return userSettingService.findUserSettingById(id).map(userSetting -> {
            userSetting.setMinTemperature(userSettingDetails.getMinTemperature());
            userSetting.setMaxTemperature(userSettingDetails.getMaxTemperature());
            userSetting.setMinHumidity(userSettingDetails.getMinHumidity());
            userSetting.setMaxHumidity(userSettingDetails.getMaxHumidity());
            UserSetting updatedUserSetting = userSettingService.saveUserSetting(userSetting);
            return ResponseEntity.ok(updatedUserSetting);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Remove a user setting by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserSetting(@PathVariable Integer id) {
        if (userSettingService.findUserSettingById(id).isPresent()) {
            userSettingService.deleteUserSettingById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // POST: Create user setting for a specific user
    @PostMapping("/user/{userId}")
    public ResponseEntity<UserSetting> createUserSetting(
            @PathVariable Integer userId,
            @Valid @RequestBody UserSettingDTO userSettingDTO) {
        UserSetting savedUserSetting = userSettingService.createUserSetting(userId, userSettingDTO);
        return ResponseEntity.ok(savedUserSetting);
    }
}
