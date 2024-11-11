package com.example.demo.layers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layers.entities.Cliente;
import com.example.demo.layers.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para cadastrar um cliente
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid Cliente cliente) {
        Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }
}
