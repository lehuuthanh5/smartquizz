package ltvnc.java.lichking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ltvnc.java.lichking.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext(unitName = "springsecurity")
	private EntityManager entityManager;

	@Override
	public User addUser(User user) {
		try {
			entityManager.persist(user);
			entityManager.flush();
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User getUserById(int id) {
		try {
			User user = entityManager.find(User.class, id);
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User getUserByUsername(String username) {
		try {
			User user = (User) entityManager.createNativeQuery(
					"select u from User u where u.username='" + username + "'",
					User.class).getSingleResult();
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			User user = (User) entityManager.createNativeQuery(
					"select u from User u where u.email='" + email + "'",
					User.class).getSingleResult();
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			entityManager.merge(user);
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser(int limit, int offset) {
		try {
			List<User> users = entityManager
					.createNativeQuery("select u from User u", User.class)
					.setFirstResult(offset).setMaxResults(limit)
					.getResultList();
			return users;
		} catch (Exception e) {
			throw e;
		}
	}

}
