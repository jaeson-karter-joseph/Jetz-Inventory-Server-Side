package com.inventory.inventory.modal;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Item extends CommonModal{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private String type;
    @ManyToOne
    private ItemCategory category;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Unit unit;
    private Double unitPrice;
    private Double quantity;
    private Double reorderLevel;
    private Double reorderQuantity;
    private Boolean active;

//    @OneToMany(mappedBy = "item",fetch = FetchType.LAZY)
//    private List<StoreMapping> storeMappings;




}
