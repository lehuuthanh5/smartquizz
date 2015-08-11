package ltvnc.java.lichking.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "shortdescription")
	private String shortDescription;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "avatarcontent")
	private byte[] avatarContent;
	@Column(name = "isenable")
	private boolean isEnable;

	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<UserRole> userRoles;
	@OneToMany(mappedBy = "sourceUser")
	private List<Message> sourceMessages;
	@OneToMany(mappedBy = "targetUser")
	private List<Message> targetMessages;

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public byte[] getAvatarContent() {
		return avatarContent;
	}

	public void setAvatarContent(byte[] avatarContent) {
		this.avatarContent = avatarContent;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public List<Message> getSourceMessages() {
		return sourceMessages;
	}

	public void setSourceMessages(List<Message> sourceMessages) {
		this.sourceMessages = sourceMessages;
	}

	public List<Message> getTargetMessages() {
		return targetMessages;
	}

	public void setTargetMessages(List<Message> targetMessages) {
		this.targetMessages = targetMessages;
	}

	public ltvnc.java.lichking.modal.User createModal() {
		ltvnc.java.lichking.modal.User userModal = new ltvnc.java.lichking.modal.User();
		userModal.setAvatar(avatar);
		userModal.setEmail(email);
		userModal.setFirstName(firstName);
		userModal.setLastName(lastName);
		userModal.setPassword(password);
		userModal.setShortDescription(shortDescription);
		userModal.setUsername(username);
		userModal.setId(id);
		return userModal;
	}
}
