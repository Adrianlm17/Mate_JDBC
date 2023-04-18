package edu.craptocraft.programjpa;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAService {
    
    private static JPAService instance;

    private EntityManagerFactory entityManagerFactory;


    private JPAService() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa-biblioteca-demo-local");
	}

    public static synchronized JPAService getInstance() {
		return instance == null ? instance = new JPAService() : instance;
	}

    public void shutdown() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public <T> T runInTransaction(Function<EntityManager, T> function){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        
        //INDICA QUE EL EXITO ES FALSO Y LUEGO CUANDO YA REALIZO TODO PASE A SER TRUE
        boolean success = false;

        //COMENZAMOS LA TRANSACCIÓN
        transaction.begin();

        try {

            T returnValue = function.apply(entityManager);
            success = true;
            return returnValue;

        } finally {
            // SI FUE EXITOSO LO GUARDA SI NO HACE UN ROLLBACK
            if (success) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
        }
    }
}
