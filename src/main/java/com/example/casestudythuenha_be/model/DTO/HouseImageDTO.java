package com.example.casestudythuenha_be.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HouseImageDTO {
    private Long id;
    private String houseName;
    private String houseAddress;
    private int bedrooms;
    private int bathrooms;
    private String description;
    private long rent;
    private String image1;
    private String image2;
    private String image3;
    private Long houseStatusId;
    private Long userId;
}
