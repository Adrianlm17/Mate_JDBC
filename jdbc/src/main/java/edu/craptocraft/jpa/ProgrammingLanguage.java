package edu.craptocraft.jpa;

import java.util.Objects;

import jakarta.persistence.*;

//ASIGNAR A LA TABLA DE BASE DE DATOS
@Entity
@Table(name = "leguaje_programa")
public class ProgrammingLanguage {

    // ASIGNAMOS ID AL ENTITY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "lp_id") // Aqui las iniciales del table + _ + lo que buscamos (en este caso id)
    private Integer id;

    @Column(name = "lp_name")
    private String nombre;

    @Column(name = "lp_nota")
    private Integer nota;

    public ProgrammingLanguage() {

    }

    public ProgrammingLanguage(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProgrammingLanguage that = (ProgrammingLanguage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getNota() {
        return this.nota;
    }
}