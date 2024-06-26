package com.diego.study.ordermanager.controller;

import com.diego.study.ordermanager.model.Client;
import com.diego.study.ordermanager.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/test")
    public String healthChech() {
        return "Rest is working";
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "List all clients")
    public ResponseEntity<Client> findClient(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
