package edu.craptocraft.programjpa;

import jakarta.persistence.EntityManagerFactory;


public class Application {
    
    private static JPAService jpaService = JPAService.getInstance();

    public static void main(String[] args) {
        try {

            EntityManagerFactory entityManagerFactory = jpaService.getEntityManagerFactory(); 
            entityManagerFactory.createEntityManagerFactory();

            
        } finally {
            jpaService.shutdown();
        }
    }
}
