package com.rating.service.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private Integer rating;
    private String remark;




}
