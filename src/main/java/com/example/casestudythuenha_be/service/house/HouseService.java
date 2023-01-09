package com.example.casestudythuenha_be.service.house;

import com.example.casestudythuenha_be.model.House;
import com.example.casestudythuenha_be.repository.IHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService implements IHouseService {
    @Autowired
    IHouseRepo iHouseRepo;

    @Override
    public List<House> findAll() {
        return iHouseRepo.findAll();
    }

    @Override
    public House findById(Long id) {
        if (iHouseRepo.findById(id).isPresent()) {
            return iHouseRepo.findById(id).get();
        }
        return null;
    }


    @Override
    public void deleteById(Long id) {
        iHouseRepo.deleteById(id);
    }

    @Override
    public House save(House house) {
        return iHouseRepo.save(house);
    }
}
