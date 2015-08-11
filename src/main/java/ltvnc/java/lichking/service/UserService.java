package ltvnc.java.lichking.service;

import java.util.HashMap;
import java.util.List;

import ltvnc.java.lichking.modal.User;

public interface UserService {
	public User addUser(User user);

	public User getUserById(int id);

	public User getUserByUsername(String username);

	public User getUserByEmail(String email);

	public void updateUser(User user);

	public List<User> getListUser(int limit, int offset);
	
	public HashMap<String, String> valiRegisUserData(User user);
	
}
