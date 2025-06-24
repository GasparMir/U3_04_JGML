package com.almacenes.gestion_almacenes.controllers;

import com.almacenes.gestion_almacenes.models.*;
import com.almacenes.gestion_almacenes.services.*;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/cedes")
public class CedeController {
    private final CedeService cedeService;

    public CedeController(CedeService cedeService) {
        this.cedeService = cedeService;
    }

    @GetMapping
    public List<Cede> getAllCedes() {
        return cedeService.getAllCedes();
    }

    @PostMapping
    public Cede createCede(@RequestBody @Valid Cede cede) {
        return cedeService.saveCede(cede);
    }

    @GetMapping("/{id}")
    public Cede getCede(@PathVariable Long id) {
        return cedeService.getCedeById(id);
    }

    @PutMapping("/{id}")
    public Cede updateCede(@PathVariable Long id, @RequestBody @Valid Cede cede) {
        cede.setId(id);
        return cedeService.saveCede(cede);
    }

    @DeleteMapping("/{id}")
    public void deleteCede(@PathVariable Long id) {
        cedeService.deleteCede(id);
    }
}