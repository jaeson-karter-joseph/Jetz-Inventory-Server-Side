package com.inventory.inventory.dto.iec;
import lombok.Data;

@Data
public class IecBranchDto {
    private Long id;
    private String branchCode;
    private String branchName;
    private String branchAddress;
    private Boolean active;
}
