package com.rw.appointment.service;

import com.rw.appointment.domain.errors.UserResourceException;
import com.rw.appointment.repository.UserRepository;
import com.rw.appointment.service.dto.UserDto;
import com.rw.appointment.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(UserDto userDto) {
        logger.info("Creating new User: {}", userDto);
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }

    public UserDto findById(String id) {
        UUID uuid = UUID.fromString(id);
        return userRepository.findById(uuid)
                .map(userMapper::userToUserDto)
                .orElseThrow(()-> new UserResourceException("User not found: " + uuid));
    }

    public List<UserDto> findAll() {
        return userMapper.usersToUsersDto(userRepository.findAll());
    }
}
