package com.almacenes.gestion_almacenes.services;

import com.almacenes.gestion_almacenes.models.Cede;
import com.almacenes.gestion_almacenes.repositories.CedeRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CedeService {
    private final CedeRepository repo;

    public CedeService(CedeRepository repo) {
        this.repo = repo;
    }

    public List<Cede> getAllCedes() {
        return repo.findAll();
    }

    public Cede getCedeById(Long id) {
        return repo.findById(id).orElse(null);
    }

 public Cede saveCede(Cede cede) {
        Cede saved = repo.save(cede);

        String date = new SimpleDateFormat("ddMMyyyy").format(new Date());
        int random = new Random().nextInt(9000) + 1000; // 1000–9999
        String clave = "C" + saved.getId() + "-" + date + "-" + random;

        saved.setClave(clave);
        return repo.save(saved);
    }


    public void deleteCede(Long id) {
        repo.deleteById(id);
    }
}