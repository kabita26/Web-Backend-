package com.example.skincare_backend.service;


import com.example.skincare_backend.dto.UserDto;
import com.example.skincare_backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String save(UserDto userDto);

    List<User> getAll();

    Optional<User> getById(Integer id);

    void deleteById(Integer id);
}
