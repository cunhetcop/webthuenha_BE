package com.example.casestudythuenha_be.controller.housestatus;

import com.example.casestudythuenha_be.model.HouseStatus;
import com.example.casestudythuenha_be.service.housestatus.IHouseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/houseStatus")
public class HouseStatusController {
    @Autowired
    IHouseStatusService houseStatusService;


    @GetMapping("/list")
    public ResponseEntity<Iterable<HouseStatus>> showAllHouseStatus() {
        Iterable<HouseStatus> users = houseStatusService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
