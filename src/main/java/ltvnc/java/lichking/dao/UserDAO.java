package ltvnc.java.lichking.dao;

import java.util.List;

import ltvnc.java.lichking.entity.User;

public interface UserDAO {

	public User addUser(User user);

	public User getUserById(int id);

	public User getUserByUsername(String username);

	public User getUserByEmail(String email);

	public void updateUser(User user);

	public List<User> getListUser(int limit, int offset);
}
