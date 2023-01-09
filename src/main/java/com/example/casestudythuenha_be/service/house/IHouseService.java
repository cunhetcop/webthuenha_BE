package com.example.casestudythuenha_be.service.house;


import com.example.casestudythuenha_be.model.House;
import com.example.casestudythuenha_be.service.IGeneralService;

import java.util.Date;

public interface IHouseService extends IGeneralService<House> {
    Iterable<House> get5HouseByRent();

    Iterable<House> searchAllHouse(int bath, int bed, String address, Date startTime, Date endTime, Long maxRent, Long minRent);

    Iterable<House> findByUserId(Long id);
    Iterable<House> findAllPage9(Long start);

   Iterable<House> findHouseByAll(String bedrooms,
                                  String bathrooms,
                                  String address,
                                  long rentMin, long rentMax,
                                  String endTime, String startTime);

}
