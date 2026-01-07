package dev.swarnadeep.lab01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		
		// 1. Load configuration
		System.out.println("Starting connection ...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.example");
		
		// 2. Create worker
		EntityManager em = emf.createEntityManager();
		
		try {
			System.out.println("--------------------------------------------------------------------");
			Object result = em.createNativeQuery("SELECT CURRENT_TIMESTAMP").getSingleResult();
			System.out.println("SUCCESS! Database connected.");
			System.out.println("Current Database Time: " + result);
			System.out.println("--------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
