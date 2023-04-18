package edu.craptocraft.librerias.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.craptocraft.librerias.repository.LibrosREpository;
import edu.craptocraft.librerias.entity.Libros;

@Service
public class LibrosService {

    @Autowired
    LibrosREpository librosRepository;

    public List<Libros> getAllLibros() {
        return librosRepository.findAll();
    }

    public Optional<Libros> getLibroById(Long id) {
        return librosRepository.findById(id);
    }

    public Libros saveLibro(Libros libro) {
        return librosRepository.save(libro);
    }

    public void deleteLibro(Long id) {
        librosRepository.deleteById(id);
    }

    public Libros updateLibro(Libros libro) {
        return librosRepository.save(libro);
    }

}
