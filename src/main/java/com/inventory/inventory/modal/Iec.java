package com.inventory.inventory.modal;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Iec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String iecNumber;
    private String importerName;
    private String gstNumber;
    private String panNumber;
    private String email;
    private String phone;
    private String headOfficeAddress;
    private Boolean active;

    @OneToMany(mappedBy = "iec", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Iecmaster> iecmasters = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, iecNumber, importerName, gstNumber, panNumber, email, phone, headOfficeAddress, active);
    }




}
