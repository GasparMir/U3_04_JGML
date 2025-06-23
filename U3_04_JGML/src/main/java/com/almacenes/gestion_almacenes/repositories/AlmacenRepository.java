package com.almacenes.gestion_almacenes.repositories;

import com.almacenes.gestion_almacenes.models.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Almacen, Long> {}