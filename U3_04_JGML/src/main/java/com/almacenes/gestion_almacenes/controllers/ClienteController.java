package com.almacenes.gestion_almacenes.controllers;

import com.almacenes.gestion_almacenes.models.*;
import com.almacenes.gestion_almacenes.services.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody @Valid Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return clienteService.getClienteById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
        cliente.setId(id);
        return clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}