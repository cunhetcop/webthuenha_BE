package com.example.casestudythuenha_be.service.housestatus;

import com.example.casestudythuenha_be.model.HouseStatus;

import java.util.Optional;

public interface IHouseStatusService {
    Iterable<HouseStatus> findAll();

    Optional<HouseStatus> findById(Long id);

    void deleteById(Long id);

    HouseStatus save(HouseStatus houseStatus);

    void delete(Long id);
}
