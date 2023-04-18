package edu.craptocraft.jpa;

import java.util.List;

public class Application {

    private static JPAService jpaService = JPAService.getInstance();

    public static void main(String[] args) {

        try {

            createProgrammingLanguages();
            printTopProgrammingLanguages();

        } finally {

            jpaService.shutdown();
        }
    }

    private static void createProgrammingLanguages() {
        jpaService.runInTransaction(entityManager -> {
            // INTERACTUAMOS CON LA BASE DE DATOS
            // EJEMPLO DE UNA CONSULTA (crea un lenguaje con sus puntos)
            entityManager.persist(new ProgrammingLanguage("Java", 10));
            entityManager.persist(new ProgrammingLanguage("JavaScript", 8));
            entityManager.persist(new ProgrammingLanguage("Python", 9));

            return null;

        });
    }

    private static void printTopProgrammingLanguages() {
        List<ProgrammingLanguage> list = jpaService.runInTransaction(entityManager -> entityManager.createQuery(
                "select lp from ProgrammingLanguage lp where lp.nota > 5",
                ProgrammingLanguage.class).getResultList());

        list.stream()
                .map(lp -> lp.getNombre() + ": " + lp.getNota())
                .forEach(System.out::println);
    }
}
