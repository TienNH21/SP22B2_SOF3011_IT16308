package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	/*
	 * Lí do ko tạo thuộc tính static factory & em
	 * https://stackoverflow.com/a/8621429
	 * https://stackoverflow.com/a/54722284/5938111
	 */
	public static EntityManagerFactory getFactory() {
		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("SP22B2_SOF3011_IT16308");
		
		return factory;
	}
	
	public static EntityManager getEntityManager() {
		EntityManager em = JpaUtil.getFactory()
			.createEntityManager();
		
		return em;
	}
}
