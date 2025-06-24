package com.almacenes.gestion_almacenes.controllers;

import com.almacenes.gestion_almacenes.models.*;
import com.almacenes.gestion_almacenes.services.*;

import jakarta.validation.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {
    private final AlmacenService almacenService;

    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping
    public List<Almacen> getAllAlmacenes() {
        return almacenService.getAllAlmacenes();
    }

    @PostMapping
    public Almacen createAlmacen(@RequestBody @Valid Almacen almacen) {
        return almacenService.saveAlmacen(almacen);
    }

    @GetMapping("/{id}")
    public Almacen getAlmacen(@PathVariable Long id) {
        return almacenService.getAlmacenById(id);
    }

    @PutMapping("/{id}")
    public Almacen updateAlmacen(@PathVariable Long id, @RequestBody @Valid Almacen almacen) {
        almacen.setId(id);
        return almacenService.saveAlmacen(almacen);
    }

    @DeleteMapping("/{id}")
    public void deleteAlmacen(@PathVariable Long id) {
        almacenService.deleteAlmacen(id);
    }

    @PostMapping("/{id}/operar")
public ResponseEntity<String> operarAlmacen(
        @PathVariable Long id,
        @RequestBody Map<String, Object> body) {
    Long clienteId = Long.valueOf(body.get("clienteId").toString());
    String tipo = body.get("tipoOperacion").toString(); // "VENTA" o "RENTA"
    String resultado = almacenService.operarAlmacen(id, clienteId, TipoOperacion.valueOf(tipo));
    return ResponseEntity.ok(resultado);
}
}