package com.example.casestudythuenha_be.service.image;

import com.example.casestudythuenha_be.model.Image;
import com.example.casestudythuenha_be.IGeneralService;

import java.util.Optional;

public interface IImageService extends IGeneralService<Image> {
    Optional<Image> findByName(String name);

    Iterable<Image> findByHouseId(Long id);
}
