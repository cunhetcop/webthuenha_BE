package com.example.casestudythuenha_be.repository;

import com.example.casestudythuenha_be.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRatingRepository extends JpaRepository<Rating, Long> {
    @Query(value = "SELECT * from rating where house_id = :id", nativeQuery = true)
    Iterable<Rating> HouseRating(@Param("id") Long id);
}
