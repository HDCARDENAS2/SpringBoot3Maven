package com.learn.springb3.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springb3.dto.UserDTO;
import com.learn.springb3.service.UserService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
@Log4j2
public class UserController {

    private final UserService userService;

    @Operation(summary =  "Find user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200"),
            @ApiResponse(responseCode  = "204")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Integer id) {
        log.info("Entering findUserById method with id: {}", id);
        UserDTO userDTO = userService.findById(id);
        log.info("Exiting findUserById method with userDTO: {}", userDTO);
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.noContent().build();
    }

    @Operation(summary = "Find all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "204")
    })
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        log.info("Entering findAllUsers method");
        List<UserDTO> users = userService.findAll();
        log.info("Exiting findAllUsers method with users: {}", users);
        return users.isEmpty() ?  ResponseEntity.noContent().build() : ResponseEntity.ok(users) ;
    }

    @Operation(summary = "Find users created today")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "204")
    })
    @GetMapping("/created-today")
    public ResponseEntity<List<UserDTO>> findUsersCreatedToday() {
        log.info("Entering findUsersCreatedToday method");
        List<UserDTO> users = userService.findUsersCreatedToday();
        log.info("Exiting findUsersCreatedToday method with users: {}", users);
        return users.isEmpty() ? ResponseEntity.noContent().build() :  ResponseEntity.ok(users);
    }
    
    @Operation(summary = "Find users created by year")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "204")
    })
    @GetMapping("/created-by-year/{year}")
    public ResponseEntity<List<UserDTO>> findUsersCreatedByYear(@PathVariable("year") Integer year) {
        log.info("Entering findUsersCreatedByYear method with year: {}", year);
        List<UserDTO> users = userService.findUsersCreatedByYear(year);
        log.info("Exiting findUsersCreatedByYear method with users: {}", users);
        return users.isEmpty() ? ResponseEntity.noContent().build() :  ResponseEntity.ok(users);
    }
    
}
