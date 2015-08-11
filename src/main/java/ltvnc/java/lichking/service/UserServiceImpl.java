package ltvnc.java.lichking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ltvnc.java.lichking.dao.UserDAO;
import ltvnc.java.lichking.modal.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User addUser(User user) {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userDAO.addUser(user.createEntity()).createModal();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUserById(int id) {
		try {
			return userDAO.getUserById(id).createModal();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUserByUsername(String username) {
		try {
			return userDAO.getUserByUsername(username).createModal();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			return userDAO.getUserByEmail(email).createModal();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		try {
			userDAO.updateUser(user.createEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getListUser(int limit, int offset) {
		try {
			List<ltvnc.java.lichking.entity.User> users = userDAO.getListUser(
					limit, offset);
			List<User> userModals = new ArrayList<User>();
			for (ltvnc.java.lichking.entity.User user : users) {
				userModals.add(user.createModal());
			}
			return userModals;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public HashMap<String, String> valiRegisUserData(User user) {
		HashMap<String, String> errors = new HashMap<String, String>();
		String s = validatePass(user.getPassword());
		if (s != "") {
			errors.put("pass", s);
		}
		s = validateEmail(user.getEmail());
		if (s != "") {
			errors.put("email", s);
		}
		s = validateRePass(user.getPassword(), user.getRePassword());
		if (s != "") {
			errors.put("repass", s);
		}
		return errors;
	}

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private String validateEmail(final String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		if (matcher.matches()) {
			if(getUserByEmail(hex) != null){
				return "The Email was registered";
			} else {
				return "";
			}
		} else {
			return "Invali Email";
		}
	}

	@SuppressWarnings("unused")
	private String validateUsername(String username) {
		if (username.length() < 6) {
			return "Username must has more than 6 characters";
		}
		if (getUserByUsername(username) != null) {
			return "Username exist";
		}
		if (username.length() > 25) {
			return "Username must has lest than 25 characters";
		}
		return "";
	}

	private String validatePass(String password) {
		if (password.length() < 6) {
			return "Password must has more than 6 characters";
		}
		if (password.length() > 25) {
			return "Password must has lest than 25 characters";
		}
		return "";
	}

	private String validateRePass(String password, String rePassword) {
		if (!password.equals(rePassword)) {
			return "Re-password is not match";
		}
		return "";
	}
}
