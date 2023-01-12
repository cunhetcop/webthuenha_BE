package com.example.casestudythuenha_be.service.image;
import com.example.casestudythuenha_be.model.Image;
import com.example.casestudythuenha_be.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService implements IImageService{

    @Autowired
    IImageRepository imageRepository;

    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Optional<Image> findByName(String name) {
        return imageRepository.searchImageByImageName(name);
    }

    @Override
    public Iterable<Image> findByHouseId(Long id) {
        return imageRepository.searchImageByHouseId(id);
    }
}
