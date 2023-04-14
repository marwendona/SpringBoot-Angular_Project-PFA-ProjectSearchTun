package com.API_User.API_User.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name="region")
public class Region {
    @Id
    @Column(name="region_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int regionId;
    @Column(name="region_name", length = 255)
    @NotBlank(message = "Le champ region name ne peut pas être nul")
    private String regionName;

    public Region(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public Region() {
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

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
