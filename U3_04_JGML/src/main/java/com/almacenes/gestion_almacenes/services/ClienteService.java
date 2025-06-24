package com.almacenes.gestion_almacenes.services;

import com.almacenes.gestion_almacenes.models.*;
import com.almacenes.gestion_almacenes.repositories.*;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> getAllClientes() {
        return repo.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return repo.findById(id);
    }

    public Cliente saveCliente(Cliente cliente) {
        return repo.save(cliente);
    }

    public void deleteCliente(Long id) {
        repo.deleteById(id);
    }
}