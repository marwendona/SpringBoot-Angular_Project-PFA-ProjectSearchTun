package com.API_User.API_User.dto;

import jakarta.validation.constraints.NotBlank;

public class RegionDto {
    private int regionId;
    @NotBlank(message = "Le champ region name ne peut pas être nul")
    private String regionName;

    public RegionDto(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public RegionDto() {
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
