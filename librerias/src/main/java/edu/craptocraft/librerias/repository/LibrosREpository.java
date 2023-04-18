package edu.craptocraft.librerias.repository;

import edu.craptocraft.librerias.entity.Libros;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LibrosREpository extends JpaRepository<Libros, Long> {

}
