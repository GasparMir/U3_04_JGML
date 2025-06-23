package com.almacenes.gestion_almacenes.services;

import com.almacenes.gestion_almacenes.models.Cliente;
import com.almacenes.gestion_almacenes.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> getAllClientes() {
        return repo.findAll();
    }

    public Cliente getClienteById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Cliente saveCliente(Cliente cliente) {
        return repo.save(cliente);
    }

    public void deleteCliente(Long id) {
        repo.deleteById(id);
    }
}