package com.rw.appointment.web.rest;

import com.rw.appointment.service.dto.UserDto;
import com.rw.appointment.service.UserService;
import com.rw.appointment.web.rest.validation.ValidUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated // @PathVariable Validation + ClientWebConfigJava
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findOne(@PathVariable(value = "id") @ValidUuid String uuid) {
        return userService.findById(uuid);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody @Valid UserDto userDto) {
        return userService.createUser(userDto);
    }
}
