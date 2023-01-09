package com.example.casestudythuenha_be.service.Image;

import com.example.casestudythuenha_be.model.Image;
import com.example.casestudythuenha_be.repository.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService implements IImageService{
    @Autowired
    IImageRepo iImageRepo;

    @Override
    public Iterable<Image> findAll() {
        return iImageRepo.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return iImageRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Image save(Image image) {
        return iImageRepo.save(image);
    }

    @Override
    public void delete(Long id) {
        iImageRepo.deleteById(id);
    }

    @Override
    public Optional<Image> findByName(String name) {
        return iImageRepo.searchImageByImageName(name);
    }

    @Override
    public Iterable<Image> findByHouseId(Long id) {
        return iImageRepo.searchImageByHouseId(id);
    }
}

