package com.example.casestudythuenha_be.service.rating;
import com.example.casestudythuenha_be.model.Order;
import com.example.casestudythuenha_be.model.Rating;
import com.example.casestudythuenha_be.service.IGeneralService;

public interface IRatingService extends IGeneralService<Rating> {
    public Iterable<Rating> RatingByHouseId(Long id);
    public Iterable<Order> createRating(Long id, Long houses_id);
}
