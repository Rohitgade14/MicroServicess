package com.patilsoft.user.service.service.impl;


import com.patilsoft.user.service.dtos.HotelDto;
import com.patilsoft.user.service.dtos.RatingDto;
import com.patilsoft.user.service.dtos.UserDto;
import com.patilsoft.user.service.entities.User;
import com.patilsoft.user.service.exceptions.UserNotFoundException;
import com.patilsoft.user.service.external.service.HotelService;
import com.patilsoft.user.service.external.service.RatingService;
import com.patilsoft.user.service.mappers.UserMapper;
import com.patilsoft.user.service.payload.StandardResponse;
import com.patilsoft.user.service.repository.UserRepository;
import com.patilsoft.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RatingService ratingService;
    private final HotelService hotelService;
    private final RestTemplate restTemplate;

    public UserDto registerUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return
                allUsers.stream().map(userMapper::toDto)
                        .collect(Collectors.toList());
    }

    public UserDto getSingleUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + userId));
        List<RatingDto> ratings = getRatingsByUserId(userId).stream()
                .map(this::addHotelInfoToRating)
                .toList();
        UserDto userDto = userMapper.toDto(user);
        userDto.setRatings(ratings);
        return  userDto;
    }

    private List<RatingDto> getRatingsByUserId(Integer userId) {
        try {
            var res = ratingService.getRatingsByUserId(userId);
            return Optional.ofNullable(res.getData()).orElse(List.of());
        } catch (Exception e) {
            return List.of();
        }
    }

    private RatingDto addHotelInfoToRating(RatingDto rating) {
        try {
            var res = hotelService.getHotels(rating.getHotelId());
            rating.setHotel(res.getData() != null ? res.getData() : new HotelDto());
        } catch (Exception e) {
            rating.setHotel(new HotelDto());
        }
        return rating;
    }


    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not with This Id" + userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getName());
        user.setAbout(userDto.getAbout());
        User updateduser = userRepository.save(user);
        return userMapper.toDto(updateduser);

    }

    @Override
    public Boolean deleteUser(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User With this id is Not Prseent"));
        userRepository.delete(user);
        return true;

    }


    public UserDto getSingleUserByRest(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user with given Id is not exist !!" + userId));
        UserDto userDto = userMapper.toDto(user);
        List<RatingDto> ratings= new ArrayList<>();
        try {
            ResponseEntity<StandardResponse<List<RatingDto>>> responseOfRatings = restTemplate.exchange("http://RATING-SERVICE/api/ratings/user/{userId}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<StandardResponse<List<RatingDto>>>() {
                    },
                    userId
            );
            log.info("{} ", responseOfRatings);
            log.info("{} ", ratings);
            if (responseOfRatings.getBody()!=null && responseOfRatings.getBody().getData()!=null) {
//                List<RatingDto>
               ratings = responseOfRatings.getBody().getData();
               // aslo we can use peek added
                ratings = ratings.stream().peek(rating -> {
                    // api call to hotel Service to get the hotel
                    // set hotel in the ratings
                    // return rating
                    ResponseEntity<StandardResponse<HotelDto>> hotelResponse = restTemplate.exchange("http://HOTEL-SERVICE/api/hotels/{hotelId}",
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<StandardResponse<HotelDto>>() {
                            },
                            rating.getHotelId()
                    );
                    HotelDto hotelDto = hotelResponse.getBody().getData();
                    rating.setHotel(hotelDto);
                }).collect(Collectors.toList());
            }
        } catch (HttpClientErrorException.NotFound e) {
            log.warn("No ratings found for userId: {}", userId);
            ratings = new ArrayList<>(); // if fail then return []
        }
        userDto.setRatings(ratings);
        return userDto;

    }
}




