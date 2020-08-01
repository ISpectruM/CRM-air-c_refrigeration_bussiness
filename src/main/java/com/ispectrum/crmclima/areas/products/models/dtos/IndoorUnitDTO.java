package com.ispectrum.crmclima.areas.products.models.dtos;

import java.time.LocalDateTime;

public class IndoorUnitDTO extends BaseAirConditionerUnitDto {

    private String compressorType;
    private LocalDateTime createdAt;

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
