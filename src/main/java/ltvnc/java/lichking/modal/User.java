package ltvnc.java.lichking.modal;

import java.util.ArrayList;
import java.util.List;

import ltvnc.java.lichking.entity.UserRole;

public class User {

	private int id;
	private String username;
	private String password;
	private String rePassword;
	private String firstName;
	private String lastName;
	private String email;
	private String shortDescription;
	private String avatar;
	private boolean isEnable;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public ltvnc.java.lichking.entity.User createEntity(){
		ltvnc.java.lichking.entity.User userEntity = new ltvnc.java.lichking.entity.User();
		userEntity.setId(id);
		userEntity.setAvatar(avatar);
		userEntity.setEmail(email);
		userEntity.setEnable(isEnable);
		userEntity.setFirstName(firstName);
		userEntity.setLastName(lastName);
		userEntity.setPassword(password);
		userEntity.setShortDescription(shortDescription);
		List<UserRole> userRoles = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		userRole.setRole("USER_ROLE");
		userRole.setUser(userEntity);
		userRoles.add(userRole);
		userEntity.setUserRoles(userRoles);
		return userEntity;
	}
}
