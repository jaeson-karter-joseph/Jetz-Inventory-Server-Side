package com.inventory.inventory.dto.unit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UnitDto {
    @NotNull(message = "ID cannot be null")
    private Long id;
    
    @NotBlank(message = "Code cannot be blank")
    @Size(max = 10, message = "Code cannot be longer than 10 characters")
    private String code;
    
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot be longer than 50 characters")
    private String name;
    
    @Size(max = 100, message = "Description cannot be longer than 100 characters")
    private String description;
    
    @NotNull(message = "Active status cannot be null")
    private Boolean active;
}
