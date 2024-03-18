package com.MyCompany.ProperyManagement.Entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PropertyTitle", nullable = false)
    private String title;
    private String description;
    private String ownerName;
    @Column (name = "EMAIL", nullable = false)
    private String ownerEmail;
    private double price;
}
