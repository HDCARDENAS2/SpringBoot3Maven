package com.learn.springb3.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springb3.dto.UserDTO;
import com.learn.springb3.exception.BussinesException;
import com.learn.springb3.exception.NotExistsException;
import com.learn.springb3.service.UserManagerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/userManager")
@RequiredArgsConstructor
@Validated
@Log4j2
public class UserManagerController {

    private final UserManagerService userManagerService;

    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "User created successfully"),
            @ApiResponse(responseCode = "204", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO) throws BussinesException {
        log.info("Entering createUser method with userDTO: {}", userDTO);
        UserDTO userCreated = userManagerService.create(userDTO);
        log.info("Exiting createUser method with UserDTO: {}", userCreated);
        return ResponseEntity.ok(userCreated);
    }

    @Operation(summary = "Delete a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "User created successfully"),
            @ApiResponse(responseCode = "204", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) throws NotExistsException {
        log.info("Entering create method with id: {}", id);
        userManagerService.delete(id);
        log.info("Exiting create method");
    }
  
}
