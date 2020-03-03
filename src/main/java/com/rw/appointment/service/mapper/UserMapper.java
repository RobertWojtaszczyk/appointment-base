package com.rw.appointment.service.mapper;

import com.rw.appointment.domain.Authority;
import com.rw.appointment.domain.User;
import com.rw.appointment.repository.AuthorityRepository;
import com.rw.appointment.repository.UserRepository;
import com.rw.appointment.service.dto.UserDto;
import com.rw.appointment.service.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserMapper {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserMapper(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin().toLowerCase());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail().toLowerCase());
        user.setImageUrl(userDto.getImageUrl());
        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        user.setPassword(encryptedPassword);
        user.setResetKey(RandomUtil.generateResetKey());
        user.setResetDate(Instant.now());
        user.setActivated(true);
        if (userDto.getAuthorities() != null) {
            Set<Authority> authorities = userDto.getAuthorities().stream()
                    .map(authorityRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
            user.setAuthorities(authorities);
        }



        return user;
    }

    public UserDto userToUserDto(User user) {
        return new UserDto(user);
    }

    public List<UserDto> usersToUserDtos(Iterable<User> users) {
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

}
