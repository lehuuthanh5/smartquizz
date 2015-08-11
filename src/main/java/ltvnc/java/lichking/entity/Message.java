package ltvnc.java.lichking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "sourceuser")
	private User sourceUser;
	@ManyToOne
	@JoinColumn(name = "targetuser")
	private User targetUser;
	@Column(name = "message")
	private String message;
	@Column(name = "time")
	private Date time;
	@Transient
	@Autowired
	private ltvnc.java.lichking.modal.Message messageModal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(User sourceUser) {
		this.sourceUser = sourceUser;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public ltvnc.java.lichking.modal.Message createModal() {
		messageModal.setId(id);
		messageModal.setMessage(message);
		messageModal.setTime(time);
		messageModal.setSourceUser(sourceUser.createModal());
		messageModal.setTargetUser(targetUser.createModal());
		return messageModal;
	}
}
