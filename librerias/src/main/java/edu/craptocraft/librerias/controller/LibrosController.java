package edu.craptocraft.librerias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.craptocraft.librerias.entity.Libros;
import edu.craptocraft.librerias.service.LibrosService;

@RestController
@RequestMapping(path = "/api/v1/libros")
public class LibrosController {

    @Autowired
    private LibrosService librosService;

    public List<Libros> getAllLibros() {
        return librosService.getAllLibros();
    }

    @PostMapping
    public void saveUpdate(@RequestBody Libros libros) {
        librosService.saveLibro(libros);
    }

    @DeleteMapping("/{id}")
    public void saveUpdate(@PathVariable("id") Long id) {
        librosService.deleteLibro(id);
    }

    @GetMapping("/{id}")
    public Libros getLibroById(@PathVariable("id") Long id) {
        return librosService.getLibroById(id).get();
    }
}
