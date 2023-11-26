package com.inventory.inventory.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Entity
@Data
public class Iecmaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchCode;
    private String branchName;
    private String branchAddress;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="iec_id")
    @JsonBackReference
    private Iec iec;

}
