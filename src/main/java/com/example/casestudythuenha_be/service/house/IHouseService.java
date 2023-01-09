package com.example.casestudythuenha_be.service.house;

import com.example.casestudythuenha_be.model.House;

import java.util.List;

public interface IHouseService {

    List<House> findAll();

    House findById(Long id);

    void deleteById(Long id);

    House save(House house);
}

