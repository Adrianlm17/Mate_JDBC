package edu.craptocraft.jpa;

import java.util.List;

public class Application {

    private static JPAService jpaService = JPAService.getInstance();

    public static void main(String[] args) {

        try {

            createBiblioteca();
            printTopBiblioteca();

        } finally {

            jpaService.shutdown();
        }
    }

    private static void createBiblioteca() {
        jpaService.runInTransaction(entityManager -> {
            
            entityManager.persist(new Biblioteca("Biblioteca Nacional de España", "Paseo de Recoletos, 20-22, 28071 Madrid"));
            entityManager.persist(new Biblioteca("Biblioteca Nacional de Colombia", "Calle 24 #5-60, Bogotá, Colombia"));
            entityManager.persist(new Biblioteca("Biblioteca Nacional del Perú", "Av. De la Poesía 160, San Borja 15037, Perú"));

            return null;

        });
    }

    private static void printTopBiblioteca() {
        List<Biblioteca> list = jpaService.runInTransaction(entityManager -> entityManager.createQuery(
                "select b from Biblioteca b where b.id <= 2",
                Biblioteca.class).getResultList());

        list.stream()
                .map(lp -> lp.getNombre() + ": " + lp.getDireccion())
                .forEach(System.out::println);
    }
}
