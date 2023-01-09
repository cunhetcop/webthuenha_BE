package com.example.casestudythuenha_be.repository;


import com.example.casestudythuenha_be.model.HouseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHouseStatusRepository extends JpaRepository<HouseStatus, Long> {
}
