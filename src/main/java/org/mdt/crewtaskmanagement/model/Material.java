package org.mdt.crewtaskmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Material extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String serialNo;
    private String name;
    private String description;
    private boolean useStatus;
    private String manufacturer;
    private BigDecimal price;
    @Column(name = "material_condition")
    private String condition;
    private String supplierInfo;
    private LocalDate receivedDate;
    private LocalDate lifeTime;
    @ManyToOne
    private Ship ship ;


}
