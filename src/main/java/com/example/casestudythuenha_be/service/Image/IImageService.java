package com.example.casestudythuenha_be.service.Image;

import com.example.casestudythuenha_be.model.HouseStatus;
import com.example.casestudythuenha_be.model.Image;

import java.util.Optional;

public interface IImageService {
    Iterable<Image> findAll();

    Optional<Image> findById(Long id);

    void deleteById(Long id);

    Image save(Image image);

    void delete(Long id);
    Optional<Image> findByName(String name);

    Iterable<Image> findByHouseId(Long id);
}
