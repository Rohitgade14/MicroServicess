package com.rating.service.repository;

import com.rating.service.entities.Rating;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository  extends JpaRepository<Rating,Integer> {

    // custom methods
    List<Rating> findByUserId(Integer userId);
    List<Rating> findByHotelId(Integer hotelId);
}
