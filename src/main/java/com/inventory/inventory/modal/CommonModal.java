package com.inventory.inventory.modal;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class CommonModal {
    @Column(name = "createdby")
    private Long createdBy;
    @Column(name = "updatedby")
    private Long updatedBy;
    @Column(name = "createddatetime")
    private String createdDateTime;
    @Column(name = "updateddatetime")
    private String updatedDateTime;

}
