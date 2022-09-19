package com.telran.repository;

import com.telran.entity.Car;
import com.telran.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    // Spring DSL
    List<Car> findAllByYear(Integer year);

    // JPQL
    // Java Persistence Query Language

    // JPQL == SQL, but about entities

    // SQL:  SELECT * FROM TABLE WHERE COLUMN='data'

    // JPQL: select * from Entity where field = 'data' (cannot use * in jpql)
    // JPQL: from Entity where field = 'data'
    // JPQL: select e from Entity e where field = 'data'
    @Query(value = "select c from Car c where c.year=:year")
    Car getMyCar(@Param("year") Integer year);




    @Query(value = "select c from Car c where c.owner.id=:ownerId")
    List<Car> getCarsByOwnerId(Long ownerId);

    List<Car> findAllByOwner_Id(Long ownerId);

    @Query(value = "select c from Car c where c.owner=:owner")
    List<Car> getCarsByOwner(Owner owner);

    List<Car> findAllByOwner(Owner owner);

    // Return Type:

    // Optional<Car>
    // Car
    //      findBy
    // Result: Car or null (empty for Optional)

    // Car
    //      getBy
    // Result: Car or exception

    // Collection/List/Set/Iterable?<Car>
    //      findAllBy

    // Stream<>


    // boolean
    //      existsBy/existsAllBy

    // void
    //      deleteBy/deleteAllBy

    // long
    //      countBy


    // findBy... what?
    //
}
