package com.adrieldsa88.caduse.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table()
@Builder
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 11)
    private String number;
    @Column(length = 3)
    private String ddd;
}
