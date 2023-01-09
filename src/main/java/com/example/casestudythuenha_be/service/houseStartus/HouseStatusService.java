package com.example.casestudythuenha_be.service.houseStartus;



import com.example.casestudythuenha_be.model.HouseStatus;
import com.example.casestudythuenha_be.repository.IHouseStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseStatusService implements IHouseStatusService {

    @Autowired
    IHouseStatusRepository houseStatusRepository;
    @Override
    public Iterable<HouseStatus> findAll() {
        return houseStatusRepository.findAll();
    }

    @Override
    public Optional<HouseStatus> findById(Long id) {
        return houseStatusRepository.findById(id);
    }

    @Override
    public HouseStatus save(HouseStatus houseStatus) {
      return   houseStatusRepository.save(houseStatus);
    }

    @Override
    public void delete(Long id) {
        houseStatusRepository.deleteById(id);
    }
}
