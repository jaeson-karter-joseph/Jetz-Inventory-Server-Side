package com.inventory.inventory.dto.iec;
import lombok.Data;
import java.util.Set;

@Data
public class IecDto {
    private String iecNumber;
    private String importerName;
    private String gstNumber;
    private String panNumber;
    private String email;
    private String phone;
    private String headOfficeAddress;
    private Boolean active;
    private Set<IecBranchDto> iecmasters;
}
