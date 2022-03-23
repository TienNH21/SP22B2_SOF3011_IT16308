package dao;

import javax.persistence.EntityManager;

import entities.User;
import utils.JpaUtil;

public class UserDAO {
	private EntityManager em;
	
	public UserDAO() {
		this.em = JpaUtil.getEntityManager();
	}
	
	public User create(User entity) {
		try {
			// Bắt đầu transaction
			this.em.getTransaction().begin();
			
			// Thêm mới đối tượng
			this.em.persist(entity);
			
			// Kết thúc transaction
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			
			this.em.getTransaction().rollback();
			return null;
		}
	}
}
