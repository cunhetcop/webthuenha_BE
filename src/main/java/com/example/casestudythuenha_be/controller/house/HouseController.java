package com.example.casestudythuenha_be.controller.house;

import com.example.casestudythuenha_be.model.DTO.HouseDTO;
import com.example.casestudythuenha_be.model.House;
import com.example.casestudythuenha_be.model.Image;
import com.example.casestudythuenha_be.service.Image.IImageService;
import com.example.casestudythuenha_be.service.house.IHouseService;
import com.example.casestudythuenha_be.service.housestatus.IHouseStatusService;
import com.example.casestudythuenha_be.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class HouseController {
    @Autowired
    IHouseService iHouseService;
    @Autowired
    IHouseStatusService iHouseStatusService;
    @Autowired
    IImageService imageService;
    @Autowired
    IUserService iUserService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<House>> showAllHouse() {
        Iterable<House> houses = iHouseService.findAll();
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<House> createHouse(@PathVariable("id") Long id, @RequestBody HouseDTO houseDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        House house = new House();
        house.setId(houseDTO.getId());
        house.setHouseName(houseDTO.getHouseName());
        house.setHouseAddress(houseDTO.getHouseAddress());
        house.setBathrooms(houseDTO.getBathrooms());
        house.setBedrooms(houseDTO.getBedrooms());
        house.setDescription(houseDTO.getDescription());
        house.setRent(houseDTO.getRent());
        house.setStatus(iHouseStatusService.findById(Long.parseLong("2")).get());
        List<Image> imageList = new ArrayList<>();

        for (int i = 0; i < houseDTO.getListImage().size(); i++) {
            Image image = new Image(houseDTO.getListImage().get(i));
            imageService.save(image);
            imageList.add(imageService.findByName(image.getImageName()).get());
            house.setImage(imageList);


        }
//        house.setUser(iUserService.findById(id).get());
        iHouseService.save(house);
        return new ResponseEntity<>(iHouseService.save(house), HttpStatus.OK);
    }
}
