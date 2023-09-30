package com.piola.PiolaSchool.controller;

import com.piola.PiolaSchool.DAO.IDuvida;
import com.piola.PiolaSchool.atributes.Duvidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duvidas")
public class DuvidaController {

    @Autowired
    private final IDuvida dao;

    public DuvidaController(IDuvida dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Duvidas> listaDuvidas () {
        return (List<Duvidas>) dao.findAll();
    }

    @PostMapping
    public Duvidas gerarDuvida(@RequestParam String duvida, @RequestParam String email,
                               @RequestParam Integer curso,  Duvidas duvidas){
        Duvidas duvidaCreate = dao.save(duvidas);
        return duvidaCreate;
    }

}
