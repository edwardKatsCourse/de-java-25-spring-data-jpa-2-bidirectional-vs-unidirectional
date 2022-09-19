package com.telran.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @OneToOne
//    @JoinColumn(name = "car_id")
//    private Car car;

    // owner id: 1
    // Name: Edward
    // Car id: 11

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    //          1 | min-max
    //       2b   2c
    //           3ac 3bc 3cc 3dc

    // new owner (own_1)
    //    new car(c_1)
    //    new car(c_2)
    //    new car(c_3)

    // car (c_1)
    //  new owner
}
