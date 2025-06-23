package com.almacenes.gestion_almacenes.services;

import com.almacenes.gestion_almacenes.models.Almacen;
import com.almacenes.gestion_almacenes.models.Cliente;
import com.almacenes.gestion_almacenes.models.EstadoAlmacen;
import com.almacenes.gestion_almacenes.models.TipoOperacion;
import com.almacenes.gestion_almacenes.repositories.AlmacenRepository;
import com.almacenes.gestion_almacenes.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

@Service
public class AlmacenService {
    private final AlmacenRepository repo;
    private final ClienteRepository clienteRepo;

    private static final Map<TipoOperacion, BiConsumer<Almacen, Cliente>> OPERACIONES = new HashMap<>();
    static {
        OPERACIONES.put(TipoOperacion.VENTA, (almacen, cliente) -> {
            almacen.setEstado(EstadoAlmacen.VENDIDO);
            almacen.setCliente(cliente);
        });
        OPERACIONES.put(TipoOperacion.RENTA, (almacen, cliente) -> {
            almacen.setEstado(EstadoAlmacen.RENTADO);
            almacen.setCliente(cliente);
        });
    }

    public AlmacenService(AlmacenRepository repo, ClienteRepository clienteRepo) {
        this.repo = repo;
        this.clienteRepo = clienteRepo;
    }

    public List<Almacen> getAllAlmacenes() {
        return repo.findAll();
    }

    public Almacen getAlmacenById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Almacen saveAlmacen(Almacen almacen) {
        return repo.save(almacen);
    }

    public void deleteAlmacen(Long id) {
        repo.deleteById(id);
    }

    public String operarAlmacen(Long idAlmacen, Long idCliente, TipoOperacion tipoOperacion) {
        Optional<Almacen> optionalAlmacen = repo.findById(idAlmacen);
        Optional<Cliente> optionalCliente = clienteRepo.findById(idCliente);

        if (optionalAlmacen.isEmpty()) {
            return "El almacén con ID " + idAlmacen + " no existe.";
        }

        if (optionalCliente.isEmpty()) {
            return "El cliente con ID " + idCliente + " no existe.";
        }

        Almacen almacen = optionalAlmacen.get();

        if (almacen.getEstado() != EstadoAlmacen.DISPONIBLE) {
            return "El almacén no está disponible para operar. Estado actual: " + almacen.getEstado();
        }

        BiConsumer<Almacen, Cliente> operacion = OPERACIONES.get(tipoOperacion);
        if (operacion == null) {
            return "Tipo de operación inválido.";
        }
        operacion.accept(almacen, optionalCliente.get());
        repo.save(almacen);
        return "Operación realizada con éxito: " + tipoOperacion.name().toLowerCase();
    }

}