package com.almacenes.gestion_almacenes.repositories;

import com.almacenes.gestion_almacenes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}