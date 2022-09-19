package com.telran.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "car")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    // Edward

}
