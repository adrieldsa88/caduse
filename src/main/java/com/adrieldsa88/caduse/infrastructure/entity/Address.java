package com.adrieldsa88.caduse.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String street;
    @Column
    private String number;
    @Column
    private String city;
    @Column(length = 2)
    private String state;
    @Column
    private String country;
    @Column(length = 9)
    private String cep;
}
