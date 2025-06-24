package com.almacenes.gestion_almacenes.repositories;

import com.almacenes.gestion_almacenes.models.*;
import org.springframework.data.jpa.repository.*;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}