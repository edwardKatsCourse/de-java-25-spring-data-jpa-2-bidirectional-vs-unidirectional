package com.telran;

import com.telran.entity.Car;
import com.telran.entity.Owner;
import com.telran.repository.CarRepository;
import com.telran.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


// Spring Beans - class, controlled by Spring Framework


// Spring Framework: Core
// @Component
// @Service

// @Repository

// Spring Framework: Web
// @Controller
// @RestController


//@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {

        Car car1 = Car.builder()
                .brand("Opel")
                .model("Astra")
                .year(2022)
                .build();

//        Car car2 = Car.builder()
//                .brand("Opel")
//                .model("Omega")
//                .year(2020)
//                .build();
//
//        Car car3 = Car.builder()
//                .brand("Seat")
//                .model("Leon")
//                .year(2020)
//                .build();


        carRepository.saveAll(List.of(car1/*, car2, car3*/));

        Owner owner = Owner.builder()
                .firstName("peter")
                .lastName("dale")
//                .car(car1)
                .build();

        ownerRepository.save(owner);

//        car1.setOwner(owner);
        carRepository.save(car1);


//        System.out.println(carRepository.findAllByYear(2020));

    }
}


//class Teacher {
//    String name; // вася пупкин
//    List<Subject> subjects; // java, js, sql, linux
//}
//
//class Subject {
//    String name; // java
//    Teacher teachers; // вася, peter, jana
//}

