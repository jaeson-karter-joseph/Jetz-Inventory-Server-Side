package com.inventory.inventory.dto;

import lombok.Data;

@Data
public class UnitDto {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Boolean active;
}
