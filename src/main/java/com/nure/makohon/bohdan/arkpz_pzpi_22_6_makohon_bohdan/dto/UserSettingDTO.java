package com.nure.makohon.bohdan.arkpz_pzpi_22_6_makohon_bohdan.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserSettingDTO {
    @NotNull(message = "Minimum temperature is required")
    private Double minTemperature;

    @NotNull(message = "Maximum temperature is required")
    private Double maxTemperature;

    @NotNull(message = "Minimum humidity is required")
    private Double minHumidity;

    @NotNull(message = "Maximum humidity is required")
    private Double maxHumidity;
}
